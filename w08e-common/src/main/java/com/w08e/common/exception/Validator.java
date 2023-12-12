package com.w08e.common.exception;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class Validator {

    private static Pattern EMAIL_PATTERN = Pattern.compile("^\\w+([\\-+.]\\w+)*@\\w+([-.]\\w+)*\\.[a-z]{2,3}");
    private static Pattern LETTER_NUMBER_PATTERN = Pattern.compile("^(?=.*[a-zA-Z].*).{6,}$");
    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]*");

    /**
     * 判断内容不为空
     * @param str str
     * @return boolean
     */
    public static boolean notEmpty(Object str) {
        return str != null && str.toString().trim().length() > 0;
    }

    /**
     * 判断内容不为空（包含数组）
     * @param str str
     * @return boolean
     */
    @SuppressWarnings("unchecked")
    public static boolean notEmptyIncludeArray(Object str) {
        if (str != null && String.valueOf(str).trim().length() > 0) {
            if (str instanceof Object[]) {
                // 增加了数组长度判断
                Object[] array = (Object[]) str;
                return array.length > 0;
            } else if (str instanceof List<?>) {
                // 增加了数组长度判断
                List<Object> list = (List<Object>) str;
                return list.size() > 0;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断内容是空
     * @param str str
     * @return boolean
     */
    public static boolean isEmpty(Object str) {
        return str == null || str.toString().trim().length() == 0;
    }

    /**
     * 检查对象是否为空
     * 要检查的数据(数据类型: String、Number、Boolean、Collection、Map、Object[])
     * @param obj obj
     * @return true: 为空; false: 不为空 <li>String：值为 null、""、"0" 时返回 true <li>
     * Number：值为 null、0 时返回 true <li>Boolean：值为 null、false 时返回 true <li>
     * Collection：值为 null、size=0 时返回 true <li>Map：值为 null、size=0 时返回
     * true <li>Object[]：值为 null、length=0 时返回 true
     */
    public static boolean empty(Object obj) {
        if (obj == null) {
            return true;
        } else if (checkStr(obj)) {
            return true;
        } else if (obj instanceof Number && ((Number) obj).doubleValue() == 0) {
            return true;
        } else if (obj instanceof Boolean && !((Boolean) obj)) {
            return true;
        } else if (obj instanceof Collection && ((Collection) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Map && ((Map) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }
    /**
     *判断字符串是否为空
     *@author liyandong
     *@date 2021-11-17 10:02
     *@param obj obj
     *@return boolean
     */
    private static boolean checkStr(Object obj){
        if( obj instanceof String ){
            String strNull = "null";
            return (obj.toString().trim().length() == 0) || (strNull.equals(obj));
        }else{
            return false;
        }
    }
    /**
     * 判断是否是合法邮箱地址
     * @param email email
     * @return boolean
     */
    public static boolean isEmail(String email) {
        Matcher m = EMAIL_PATTERN.matcher(email);
        return m.matches();
    }

    /**
     * 只包含英文字母和数字、下划线
     * @param str str
     * @return boolean
     */
    public static boolean onlyNumAndChar(String str) {
        String regex = "^[a-zA-Z0-9_]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }

    /**
     * 必须包含字母
     * @param str str
     * @return boolean
     */
    public static boolean hasLetterAndNum(String str) {
        return LETTER_NUMBER_PATTERN.matcher(str).matches();
    }

    /**
     * 是否长度符合
     * @param str 字符串
     * @param min 最小
     * @param max 最大
     * @return boolean
     */
    public static boolean lengthBetween(String str, int min, int max) {
        return str.length() >= min && str.length() <= max;
    }

    /**
     * 判断字符串是否是数字
     * @param str str
     * @return boolean
     */
    public static boolean isNumeric(String str) {
        Matcher isNum = NUMBER_PATTERN.matcher(str);
        return isNum.matches();
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 15+除4的任意数
     * 18+除1和4的任意数
     * 17+除9的任意数
     * 147
     **/
    public static boolean isMobilePhone(String str) {
        String regExp = "^1[0-9]{10}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

}
