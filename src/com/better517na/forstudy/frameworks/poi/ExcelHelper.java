/*
 * 文件名：ExcelHelper.java
 * 版权：Copyright 2007-2016 517na Tech. Co. Ltd. All Rights Reserved. 
 * 描述： ExcelHelper.java
 * 修改人：tianzhong
 * 修改时间：2016年3月24日
 * 修改内容：新增
 */
package com.better517na.forstudy.frameworks.poi;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * TODO 列表的Excel导入导出Helper.
 * 
 * @author tianzhong
 */
public class ExcelHelper {

    /**
     * TODO 从外部导入设备列表到数据库.
     * 
     * @param filePath
     *            文件导入路径.
     * 
     * @return List<EquipmentVo> 解析excel文档后的设备列表.
     * @throws Exception
     *             .
     */
    @SuppressWarnings("resource")
    public static List<EquipmentVo> parseEquipmentExcel(String filePath) throws Exception {
        List<EquipmentVo> list = new ArrayList<EquipmentVo>();
        FileInputStream in = null;

        try {
            Workbook book = null;
            in = new FileInputStream(filePath);

            try {
                book = new XSSFWorkbook(filePath);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(filePath);
                book = new HSSFWorkbook(in);
            }

            int sheets = book.getNumberOfSheets();
            for (int k = 0; k < sheets; k++) {
                Sheet sheet = book.getSheetAt(k);
                int rows = sheet.getPhysicalNumberOfRows(); // 获取所有行数
                int columns = 0;
                Map<String, Integer> map = new HashMap<String, Integer>();
                for (int i = 0; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    if (row == null) { // 行为空
                        return null;
                    }
                    if (i == 0) {
                        columns = row.getPhysicalNumberOfCells(); // 获取该行所有列
                        map = getIndexMap(row, columns); // 第一行，获取各列对应的model的字段的坐标
                        continue;
                    }

                    EquipmentVo vo = new EquipmentVo();
                    setValueToVo(vo, sheet, i, map, columns); // 把每行的值注入到设备vo里
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return list;
    }

    /**
     * TODO 导出设备列表为为外部excel文档.
     * 
     * @param filePath
     *            文件导出路径.
     */
    public static void equipmentExcelExport(String filePath) {

    }

    /**
     * TODO 把每行的值注入到设备vo里.
     * 
     * @param vo
     *            设备vo.
     * @param sheet
     *            sheet.
     * @param index
     *            当前行.
     * @param indexMap
     *            索引map.
     * @param columns
     *            总列数.
     */
    private static void setValueToVo(EquipmentVo vo, Sheet sheet, int index, Map<String, Integer> indexMap, int columns) {
        try {
            Row fisrtRow = sheet.getRow(0); // 获取第一行：表头
            Row row = sheet.getRow(index); // 获取当前行对象
            for (int i = 0; i < columns; i++) {
                Cell cell = row.getCell(i);
                if (cell == null) { // 单元格为空
                    continue;
                }

                String cellValue = "";
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_FORMULA:
                        cellValue = cell.getCellFormula();
                        break;
                    case Cell.CELL_TYPE_NUMERIC: // 数字型（数字/日期）
                        if (HSSFDateUtil.isCellDateFormatted(cell)) { // 日期
                            cellValue = DateUtil.dateToString(cell.getDateCellValue());
                        } else {
                            DecimalFormat df = new DecimalFormat("0");
                            cellValue = df.format(cell.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_STRING:
                        cellValue = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        cellValue = cell.getBooleanCellValue() + "";
                        break;
                    default:
                        break;
                }
                cellValue = cellValue.trim();

                switch (fisrtRow.getCell(i).getStringCellValue()) {
                    case "设备名":
                        vo.setEqmName(cellValue);
                        break;
                    case "设备类别":
                        vo.setEqmClass(cellValue);
                        break;
                    case "设备价格":
                        vo.setEqmPrice(new BigDecimal(cellValue));
                        break;
                    case "设备厂商":
                        vo.setEqmFactory(cellValue);
                        break;
                    case "设备型号":
                        vo.setEqmType(cellValue);
                        break;
                    case "设备状态":
                        vo.setEqmStatus(cellValue);
                        break;
                    case "采购人":
                        vo.setBuyStaff(cellValue);
                        break;
                    case "采购时间":
                        vo.setBuyTime(DateUtil.stringToDate(cellValue));
                        break;
                    case "所属学院":
                        vo.setCollege(cellValue);
                        break;
                    case "设备所在实验室":
                        vo.setEqmLab(cellValue);
                        break;
                    case "托管人账号":
                        vo.setManagerId(cellValue);
                        break;
                    case "托管人姓名":
                        vo.setManager(cellValue);
                        break;
                    case "备注":
                        vo.setDescription(cellValue);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * TODO 获取字段索引map.
     * 
     * @param row
     *            行对象.
     * @param columns
     *            总列数.
     * @return Map.
     */
    private static Map<String, Integer> getIndexMap(Row row, int columns) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < columns; i++) {
            map.put(row.getCell(i).getStringCellValue().trim(), i);
        }

        return map;
    }
}
