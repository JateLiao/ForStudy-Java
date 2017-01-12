package com.better517na.forStudy;

/**
 * @author tianzhong
 *
 */
public class Info {
    
    public int i ;

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "您的中奖金额：0.50￥\n接收账户：374682617@qq.com", "来消息了!", JOptionPane.YES_OPTION);
        System.out.println("含2早有窗".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("含早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("有早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("无早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("不含早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("单早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("双早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("两早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("2早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("三早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("3早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("4早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("6早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("8早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("四早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("六早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("八早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("每人一份早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
        System.out.println("2份中早".matches(".*[无|有|两|含|单|双|三|四|六|八|\\d]早.*|.*每人一份早.*|[0-9]{1,2}份中早.*"));
    }
}
