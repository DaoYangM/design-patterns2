package top.daoyang.structural.filterpattern;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Rubbish> rubbishList = new ArrayList<>();
        rubbishList.add(new Rubbish("果壳", false, false, true, false));
        rubbishList.add(new Rubbish("陶瓷", false, false, true, false));
        rubbishList.add(new Rubbish("菜根菜叶", false, false, false, true));
        rubbishList.add(new Rubbish("果皮", false, false, false, true));
        rubbishList.add(new Rubbish("水银温度计", true, false, false, false));
        rubbishList.add(new Rubbish("电池", true, false, false, false));
        rubbishList.add(new Rubbish("灯泡", true, false, false, false));
        rubbishList.add(new Rubbish("废纸塑料", false, true, false, false));
        rubbishList.add(new Rubbish("金属和布料", false, true, false, false));
        rubbishList.add(new Rubbish("玻璃", false, true, false, false));

        RubbishFilter dryRubbishFilter = new DryRubbishFilter();
        System.out.println(dryRubbishFilter.rubbishFilter(rubbishList));

        RubbishFilter harmfulRubbishFilter = new HarmfulRubbishFilter();
        System.out.println(harmfulRubbishFilter.rubbishFilter(rubbishList));

//        product_ids:"34422141"
//        end_product_id:"34422141
//        _sign:4ca479bebe56f99c25feda34887a2353
//        _appid:NVqQtlyvsVMdBTYeTugcISaKkKXJBJsm
//        _timestamp:1572604977427
//        SortedMap<String, Object> paramters = new TreeMap();
//        paramters.put("product_ids", "236");
//        paramters.put("end_product_id", "34423013");
//        paramters.put("_appid", "NVqQtlyvsVMdBTYeTugcISaKkKXJBJsm");
//        paramters.put("_appsecret", "MAxwHozUxdpcblvPsRnsjWvfoHpaYszsVhAduQGwgHKkusGkERlbadTUEusnZlCLstysGXkWFJqNgGaAXGAjadFvFxddZLuEXohUvtLpiSllaLUEGzlRUghKeDAHyQuL");
//        long value = System.currentTimeMillis();
//        System.out.println(value);
//        paramters.put("_timestamp", value);
//
//
//        System.out.println(createSign(paramters));
    }
}
//
//
//    /**
//     * 微信支付签名算法sign
//     * @param parameters
//     * @return
//     */
//    public static String createSign(SortedMap<String,Object> parameters){
//        StringBuffer sb = new StringBuffer();
//        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
//        Iterator it = es.iterator();
//        while(it.hasNext()) {
//            Map.Entry entry = (Map.Entry)it.next();
//            String k = (String)entry.getKey();
//            Object v = entry.getValue();
//            sb.append(k + "=" + v + "&");
//        }
//
//        sb = sb.delete(sb.length() - 1, sb.length());
////
////        sb.append("key=" + //这里是商户那里设置的key);
////                System.out.println("签名字符串:"+sb.toString());
////        System.out.println("签名MD5未变大写：" + MD5Util.MD5Encode(sb.toString(), characterEncoding));
//        String sign = md5Password(sb.toString());
//        return sign.toLowerCase();
//    }
//    /**
//     * 生成32位md5码
//     *
//     * @param key
//     * @return
//     */
//    public static String md5Password(String key) {
//        char hexDigits[] = {
//                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
//        };
//        try {
//            byte[] btInput = key.getBytes();
//            // 获得MD5摘要算法的 MessageDigest 对象
//            MessageDigest mdInst = MessageDigest.getInstance("MD5");
//            // 使用指定的字节更新摘要
//            mdInst.update(btInput);
//            // 获得密文
//            byte[] md = mdInst.digest();
//            // 把密文转换成十六进制的字符串形式
//            int j = md.length;
//            char str[] = new char[j * 2];
//            int k = 0;
//            for (int i = 0; i < j; i++) {
//                byte byte0 = md[i];
//                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
//                str[k++] = hexDigits[byte0 & 0xf];
//            }
//            return new String(str);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}
