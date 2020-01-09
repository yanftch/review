
fun main(args: Array<String>) {
    println("Hello World!")

    val string: String = "hello"

    println("$string")

    val dashItems = mutableListOf("100", "200", "300")
    println(dashItems)
    println("***********")
    val dashs : List<Int> = dashItems.map { it.toInt() }
    val test = dashs.run {
        if (string.isNotEmpty()) {
            print("kong")
            this.dropLast(1)
        }else {
            this

        }
    }

    println(dashs)
    println(test)
    println("***********")


    val result_let = string.let {
        println(it)
        it.substring(0, 3)
    }
    println("result_let====>$result_let")

    println("string===>$string")

    val result_apply = string.apply {
        println("apply-1: ${this.get(1)}")
        println("apply-2: ${this.get(2)}")
        println("apply-3: ${this.get(3)}")

    }
    println("result_apply====>$result_apply")

    println("string===>$string")

    val result_with = with(ArrayList<String>()) {
        this.add("a")
        this.add("b")
        this
    }
    println("result_with====>$result_with")

    val result_run = string.run {
        this.split("l")
    }
    println("result_run====>$result_run")


    val json = """zjx0496
18810862954
290128740
bin19970119
w879045438
fableYu
youxiaoyi1995
Mr_Li_LAN
coolyellow_wx
93401948
ypp_brait
CHENGLIANGLIANG007
wzpop_384094206
wwzm99
zhao_kd
liulangsdream
catsky
cisco-cleaner
zrf540592766
wvitas
lxy199123
MeteorRen
10663271
yxiaoma
wenyuan89
lcx18710346374
a675090087
happyhuangjinjin
黄Yien
lanjixingxun
will345979590
MathlTEduLife
ice-0015
mr323310
huangqihua_dm
im_bin_go
lhj0405
nemoon
nk19920630
woaini886myp
baoying86
ZILE1314
lllxhxsh
Blueskytianyu
a15018632561
YJY_Chosen
w962831870
YuCheung_Octopus
wjc3594
kcajlmml
shihang_weixin
zhong951115229
w373138483
LSY940317
accentzhou
aowending
xj19921101
y-sons
yangdeyouxi
GX15034943634XG
zxh_heart
flx2987880371
xile6873
innovator_CL
719949039
twlkyao
wangseric
kello_guitar
jwh147
x1971481259
M33461287
joysonchen123
tianbo8236336
long532084
jerry_anxiu
cai874462
Not_me_
kim95cn
lk296436281
adxiaoxue
Herrick_XU
lzjun
J--kenny
lingguiqin
liao_monkey
18718688487
wx_doublezuo
junjiaLee2014
15937972785
GQH-XP
hehaitao074
18153512510
zjjne1407
13336021537
zr-310834626
yinweilove
13240371551
ma_zz53
snailgogohuang
hn347167359
jiangshibin0806
z18656688590
ivarcn
jackie2001
Coder_zhangx
li1032907255
Mr.Jun
lql6619
17621860286
whm_tony
yuyong1992
18917566173
ybyq0123
zhangjinglong0925
wjf322323
ab314cd
qq1486578561
744946073
srs0116
luhh009
songtao_no1
wxid_iu0spiajlud122
King_Zhang_CH
lihexiang2012
moonywatch
zhuazi2009999
f180724
JoyTingSon""".trim()
    val split = json.split("\r")
    split.forEach {
        //        print(it)
    }
}