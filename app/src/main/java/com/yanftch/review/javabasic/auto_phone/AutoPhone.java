//package com.yanftch.review.javabasic.auto_phone;
//
//import java.io.BufferedInputStream;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//
///**
// * 自动生成手机号，并且导出 Excel 文件
// */
//public class AutoPhone {
//
//    public static void main(String[] args) {
//        exportExcel();
//    }
//
//    private static List<auto_phone.UserContact> generateUsers(int size) {
//        List<auto_phone.UserContact> list = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            auto_phone.UserContact user = generateUser();
//            list.add(user);
//        }
//        // 手机号去重操作
//        List<auto_phone.UserContact> tempList = list;
//
//        for (int i = 0; i < tempList.size(); i++) {
//            for (int j = i + 1; j < tempList.size(); j++) {
//                if (tempList.get(i).getPhone().equals(tempList.get(j).getPhone())) {
//                    list.remove(i);
//                }
//            }
//        }
//        return list;
//    }
//
//    private static auto_phone.UserContact generateUser() {
//        return new auto_phone.UserContact(generateName(), generatePhoneNumber());
//    }
//
//    private static String generateName() {
//        String[] chrs = {",", "@", "#", "$", "|", ".", "?"};
//        String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
//        String lastName = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
//        Random random = new Random();
//        int fName = random.nextInt(firstName.length() - 1);
//        int lName = random.nextInt(lastName.length() - 1);
//        char c = firstName.charAt(fName);
//        char c2 = lastName.charAt(lName);
//        return "QD9" + c + c2;
//    }
//
//    /**
//     * 生成手机号
//     */
//    private static String generatePhoneNumber() {
//        return qingdao() + endMobileNo();
//    }
//
//    private static String start7() {
//        return startMobileNo() + middleMobileNo();
//    }
//
//    private static int startMobileNo() {
//        int[] mobileStart = {139, 138, 137, 136, 135, 186, 145, 133, 153, 134, 130, 131, 132, 147, 159, 158, 157, 182, 156, 150, 151, 152, 185, 188, 166, 169, 199, 130, 131, 132, 156, 184, 155, 133, 178, 183, 189, 180, 177, 176};
//        Random r = new Random();
//        ArrayList<Integer> mobileList = new ArrayList<>();
//        for (int i = 0; i < mobileStart.length; i++) {
//            mobileList.add(mobileStart[i]);
//        }
//        return mobileList.get(r.nextInt(mobileList.size()));
//    }
//
//
//    private static String middleMobileNo() {
//        Random r = new Random();
//        StringBuilder middle = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            middle.append(r.nextInt(10));
//        }
//        return middle.toString();
//    }
//
//    private static String endMobileNo() {
//        Random r = new Random();
//        StringBuilder end = new StringBuilder();
//        for (int i = 0; i < 4; i++) {
//            end.append(r.nextInt(10));
//        }
//        return end.toString();
//    }
//
//    /**
//     * 城市的前 7 位
//     * 青岛手机号前 7 位
//     */
//    private static String qingdao() {
//        String[] arr = {"1321028", "1876542", "1526924", "1321023", "1766063", "1895325", "1835428", "1836399", "1571278", "1558864", "1355302", "1786684", "1505320", "1558987", "1364648", "1516666", "1766402", "1872474", "1555424", "1596542", "1756174", "1595328", "1580656", "1866976", "1826662", "1590893", "1786423", "1835425", "1502007", "1502008"};
//        int length = arr.length;
//        Random random = new Random();
//        int nextInt = random.nextInt(length - 1);
//        return arr[nextInt];
//    }
//
//    /**
//     * 城市的前 7 位
//     * 北京手机号前 7 位
//     */
//    private static String beijing() {
//        String[] arrBJ = {"1861076", "1831025", "1861826", "1571146", "1571145", "1500137", "1398600", "1391100", "1891198", "1881064", "1881065", "1861246", "1891054", "1581032", "1886687", "1521001", "1381137", "1836383"};
//        int l = arrBJ.length;
//        Random rBJ = new Random();
//        int nextInt = rBJ.nextInt(l - 1);
//        return arrBJ[nextInt];
//    }
//
//
//    private static void exportExcel() {
//        List<auto_phone.UserContact> userContacts = generateUsers(3000);
//
//        auto_phone.ExportExcel<auto_phone.UserContact> exportExcel = new auto_phone.ExportExcel<auto_phone.UserContact>();
//        // 给生成的 Excel 文件随机命名
//        Random random = new Random();
//        String[] c = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
//        String s = c[random.nextInt(c.length - 1)];
//        String s2 = c[random.nextInt(c.length - 1)];
//        int nextInt = random.nextInt(10);
//        String fileName = nextInt + s + s2;
//
//        String[] headers = {"姓名", "手机号码"};
//
//        try {
//            BufferedInputStream bis = new BufferedInputStream(
//                    new FileInputStream("/Users/yanftch/Documents/contacts/book.png"));
//            byte[] buf = new byte[bis.available()];
//            while ((bis.read(buf)) != -1) {
//            }
//            OutputStream out = new FileOutputStream("/Users/yanftch/Documents/contacts/" + fileName + ".xls");
//            exportExcel.exportExcel(headers, userContacts, out);
//            out.close();
////            JOptionPane.showMessageDialog(null, "导出成功!");
//            System.out.println("excel导出成功！");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}