package com.job5156.common.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.job5156.beans.ServerConfig;
import com.job5156.beans.ServerConfigLoader;
import com.job5156.common.CommonEnum.ConvertType;
import com.job5156.vo.api.ChineseConvertResult;

public class ChineseCodeChangeUtil {
	private static Logger logger = Logger.getLogger(ChineseCodeChangeUtil.class);
	
    public final static String simplifiedChar = "丢并干夫布占畲来局俣系幸咱杰备效家雇当尽罗攒凶兑内册幂涂渎处别剥铲札胜绩匀汇奁椟恤咤吴唣念问衔岩尝恶苏回囱国垧埯采执阶尧报碱茔尘砖硗寿梦姗娱淫袅嬷懒尴届昆嵛襕荫廪强彝彦雕恒耻悦闷爱栗殷虑戚欲懔蒙欢戬户扦舍背构摇榨撑考败驱毙旗晋畅胧栅荣盘规檩苘钦殁毁绒球牦泛污没莅渌渊灭荥颍潜舄澄阔灾照辉茕荧颎磷营耀笺闸荦获珏璃管瑶莹罂迭酸荡视眦硅碜秘禄秃籼税谷颖颓节范蓑藤钥纟纠纪纣约红纡纥纨纫纹纳纽纾纯纰纼纱纮纸级纷纭纴纺细绂绁绅纻绍绀绋绐绌终组绊绗结绝绦绔绞络绚给绖统绛绢绑绡绠绨绣绤绥经综缍绿绸绻线绶维绹绾纲网绷缀纶绺绮绽绰绫绵绲缁绯缗绪绬绱缃缄缂缉缎缔缘缌编缓缅纬缑缈练缏缇致缊萦缙缢缒绉缣缞缚缜缟缛缝缡缩纵缧纤缦缕缥缫缪襁缯织缮翻缭绕缋绳绘茧缰缳缲缴绎继缤缱颣缬纩续缠缨缵缆钵骂芈膻锄闻脉脱铺馆艹麻蜕里见觃觅觇觋觍觎觊觏觑觐觉览觌观讠订讣计讯讧讨讦讱训讪讫记讹讶讼诀讷谌讻访设许诉诃诊证诂诋讵诈诒诏评诐诇诎诅词诩询诣试诗诧诟诡诠诘话该详诜诙诖诔诛诓认诳诶诞诱诮语诚诫诬误诰诵诲说谁课谇诽谊调谄谆谈诿请诤诹诼谅论谂谀谍谞谝谥诨谔谛谐谏谕讳谙讽诸谚谖诺谋谒谓诌谎谜谧谑谡谤谦讲谢谣谟谪谬讴谨谩谲讥谮识谯谭谱谵译议谴诪谫读雠谗让谰谶赞谠谳贝贞贠负财贡贫货贩贪贯责贮贳赀贰贵贬贷贶费贴贻贸贺贲赂赁贿赅资贾贼赃赈赊赇赒赉赐赏赔赓贤贱赋赕质赍账赌赆赖赗赚赙购赛赜贽赘赟赠赝赡赢赑赎赣迹车轧轨轪轩轫轭软轷轸轱轴轵轺轲轶轼较辂辁辀载轾辄辅轻辆辎辋辍辊辇辈轮辌辑辏输辐辒辗辖辕辘转辙轿辚轰辔轹轳迤遥酬钆钇钌钊钉钋针钓钐钏钒钗钍钕钎钯钫钘钭钚钠钝钩钤钣钑钞钮钧钟钙钬钛钪铌铈钶铃钴钹铍钰钸铀钿钾铁钻铊铉铋铂钷钳铆铅钺钲钼钽锎铏铰铒铬铪银铳铜铚铣铨铢铭铫铦铑铷铱铟铵铥铕铯铐铞锐销锈锑锉铝镅锒锌钡铤铗锋铻镯锊锓铘锃锔锇铓铖锆锂铽锍锯钢锞锖锫锩铔锥锕锟锤锱铮锛锬锭锜钱锦锚锠锡锢错锰铼镎锝锨锪钔锴锳锅镀锷铡钖锻锽锸锲锘锹锾键锶锗镁锿镑镕锁镉镈镃钨镏铠铩锼镐镇镒镋镍镓镌镞链镆镙镠镝铿锵镗镘镛镜镖镂镚铧镤镪铙铴镣铹镦镡镫镢镨锏镄镰镭镮铎铛镱铸镬镔镲锧镴铄镳镥镧镵镶镊镩锣长门闩闪闫闬闭闶闳闰闲间闵闹阂阁阀闺闽阃阆闾阅阊阉阎阏阍阈阌阒闱阕阑阇阗阘闿阖阙闯阚阓阐阛闼鸡韧鼗韦韨韩韪韬韫页顶顷项顺顸须顼颂颀颃预顽颁顿颇领颌颉颐颏颒颊颋颕颔颈频颗题额颚颜颙颛颡颠颟颢顾颤颥颦颅颞颧风飐飑飒飓飔飖飕飗飘飙飞饥饤饦饨饪饫饬饭饮饴饲饱饰饳饺饸饼饷饵饹饻饽馁饿馂饾馄馃饯馅饧馉馇馎饩馈馏馊馌馍馒馐馑馓馔饶馋馕马驭驮驰驯驲驳驻驽驹驵驾骀驸驶驼驷骈骇骃骆骎骏骋骍骓骔骒骑骐验骛骗鬃骙骞骘骝驺骚骟骡骜骖骠骢骅骕骁骣骄驿骤驴骧骥骦骊骉鲠鬓鱼鱽鱾鲀鲁鲂鱿鲄鲅鲆鲌鲉鲧鲏鲇鲐鲍鲋鲊鲒鲘鲕鲖鲔鲛鲑鲜鲓鲪鳀鲝鲩鲤鲨鲬鲻鲯鲭鲞鲷鲴鲱鲵鲲鲳鲸鲮鲰鲶鲺鲹鲫鳊鳈鲗鳂鲽鳇鳅鲾鳄鳆鳃鳁鳒鳑鳋鲥鳏鳎鳐鳍鲢鳌鳓鳘鲦鲣鳗鳛鳔鳉鳙鳕鳖鳟鳝鳜鳞鲟鲼鲎鲙鳣鳡鳢鲿鲚鳠鲈鲡鸟鸠鸤鸣鸢鸩鸨鸦鸰鸵鸳鸲鸮鸱鸪鸯鸭鸴鸸鸹鸻鸿鸽鸺鸼鹀鹃鹆鹁鹈鹅鹄鹉鹌鹏鹐鹎鹊鹓鹍鸫鹑鹒鹋鹙鹕鹗鹖鹛鹜鸧鹟鹤鹠鹡鹘鹣鹚鹢鹞鹝鹧鹥鸥鸷鹨鸶鹪鹔鹩鹫鹇鹬鹰鹭鹯鹱鹲鸬鹴鹦鹳鹂鸾鹾麦麸黄黾鼋鼌鼍鼹齐齑齿龀龁龂龅龇龃龆龄龈龊龉龋龌龙龚龛龟万与丑专业丛东丝两严丧个丬丰临为丽举么义乌乐乔习乡书买乱争于亏云亘亚产亩亲亵亸亿仅从仑仓仪们价众优伙会伛伞伟传伤伥伦伧伪伫体余佣佥侠侣侥侦侧侨侩侪侬俦俨俩俪俭债倾偬偻偾偿傥傧储傩儿兖党兰关兴兹养兽冁冈写军农冢冯冲决况冻净凄凉凌减凑凛几凤凫凭凯击凼凿刍划刘则刚创删刬刭刽刿剀剂剐剑剧劝办务劢动励劲劳势勋勐勚匦匮区医华协单卖卢卤卧卫却卺厂厅历厉压厌厍厕厢厣厦厨厩厮县参叆叇双发变叙叶号叹叽吁后吓吕吗吣吨听启呒呓呕呖呗员呙呛呜咏咔咙咛咝咴咸哌响哑哒哓哔哕哗哙哜哝哟唛唝唠唡唢唤唿啧啬啭啮啰啴啸喷喽喾嗫呵嗳嘘嘤嘱噜噼嚣团园围囵图圆圣圹场坂坏块坚坛坜坝坞坟坠垄垆垒垦垩垫垭垯垱垲垴埘埙埚堑堕塆墙壮声壳壶壸复够头夸夹夺奂奋奖奥妆妇妈妩妪妫姜娄娅娆娇娈娲娴婳婴婵婶媪嫒嫔嫱孙学孪宁宝实宠审宪宫宽宾寝对寻导将尔尸层屃屉属屡屦屿岁岂岖岗岘岙岚岛岭岳岽岿峃峄峡峣峤峥峦崂崃崄崭嵘嵚嵝嵴巅巩巯币帅师帏帐帘帜带帧帮帱帻帼幞广庄庆庐庑库应庙庞废庼开异弃张弥弪弯弹归录彟彻径徕御忆忏忧忾怀态怂怃怄怅怆怜总怼怿恋恳恸恹恺恻恼恽悫悬悭悯惊惧惨惩惫惬惭惮惯愍愠愤愦愿慑慭憷懑戆戋戏戗战扎扑扩扪扫扬扰抚抛抟抠抡抢护担拟拢拣拥拦拧拨择挂挚挛挜挝挞挟挠挡挢挣挤挥挦捞损捡换捣据捻掳掴掷掸掺掼揸揽揿搀搁搂搅携摄摅摆摈摊撄撵撷撸撺擞敌敛数斋斓斗斩断无旧时旷旸昙昼昽显晒晓晔晕晖暂暧术朴机杀杂权条杨杩极枞枢枣枥枧枨枪枫枭柜柠柽栀标栈栉栊栋栌栎栏树栖样栾桊桠桡桢档桤桥桦桧桨桩梼梾检棂椁椠椤椭楼榄榇榈榉槚槛槟槠横樯樱橥橱橹橼檐欤欧歼殇残殒殓殚殡殴毂毕毡毵氇气氢氩氲汉汤汹沓沟沣沤沥沦沧沨沩沪沵泞泪泶泷泸泺泻泼泽泾洁洒洼浃浅浆浇浈浉浊测浍济浏浐浑浒浓浔浕涌涛涝涞涟涠涡涢涣涤润涧涨涩淀渍渐渑渔渖渗温游湾湿溃溅溆溇滗滚滞滟滠满滢滤滥滦滨滩滪潆潇潋潍潴澜濑濒灏灯灵灿炀炉炖炜炝点炼炽烁烂烃烛烟烦烧烨烩烫烬热焕焖焘煅煳熘爷牍牵牺犊状犷犸犹狈狍狝狞独狭狮狯狰狱狲猃猎猕猡猪猫猬献獭玑玙玚玛玮环现玱玺珉珐珑珰珲琎琏琐琼瑷璇璎瓒瓮瓯电画畴疖疗疟疠疡疬疮疯疱疴痈痉痒痖痨痪痫痴瘅瘆瘗瘘瘪瘫瘾瘿癞癣癫癯皑皱皲盏盐监盖盗眍眬着睁睐睑瞒瞩矫矶矾矿砀码砗砚砜砺砻砾础硁硕硖硙硚确硷碍碛碹礼祎祢祯祷祸禀禅离秆种积称秽秾稆稣稳穑穷窃窍窑窜窝窥窦窭竖竞笃笋笔笕笼笾筑筚筛筜筝筹签简箓箦箧箨箩箪箫篑篓篮篱簖籁籴类粜粝粤粪粮糁糇紧絷缐罚罢罴羁羟羡翘翙翚耢耧耸聂聋职聍联聩聪肃肠肤肷肾肿胀胁胆胨胪胫胶脍脏脐脑脓脔脚脶脸腊腌腘腭腻腼腽腾膑臜舆舣舰舱舻艰艳艺芗芜芦苁苇苈苋苌苍苎苹茎茏茑荆荐荙荚荛荜荞荟荠荤荨荩荪荬荭荮药莜莱莲莳莴莶莸莺莼萚萝萤萧萨葱蒇蒉蒋蒌蓝蓟蓠蓣蓥蓦蔷蔹蔺蔼蕲蕴薮藁藓虏虚虫虬虮虽虾虿蚀蚁蚂蚕蚝蚬蛊蛎蛏蛮蛰蛱蛲蛳蛴蜗蜡蝇蝈蝉蝎蝼蝾螀螨蟏衅补衬衮袄袆袜袭袯装裆裈裢裣裤裥褛褴觞触觯詟誉誊谘豮赪赵赶趋趱趸跃跄跖跞践跶跷跸跹跻踊踌踪踬踯蹑蹒蹰蹿躏躜躯辞辩辫边辽达迁过迈运还这进远违连迟迩迳适选逊递逦逻遗邓邝邬邮邹邺邻郁郄郏郐郑郓郦郧郸酝酦酱酽酾酿释巨鉴銮錾锺阄阋队阳阴阵际陆陇陈陉陕陧陨险随隐隶隽难雏雳雾霁霉霭靓静靥鞑鞒鞯鞴韵飏飨餍髅髋髌魇魉黉黡黩黪齄志制只松面准拼";
    private final static char[] simplifiedChars;
    private final static char[] simplifiedChars2;
    public final static String traditionalChar = "丟並乾伕佈佔佘來侷俁係倖偺傑備傚傢僱儅儘儸儹兇兌內冊冪凃凟処別剝剷劄勝勣勻匯匲匵卹吒吳唕唸問啣喦嘗噁囌囘囪囯坰垵埰執堦堯報堿塋塵塼墝壽夢姍娛婬嫋嬤嬾尲屆崐崳幱廕廩強彜彥彫恆恥悅悶愛慄慇慮慼慾懍懞懽戩戶扡捨揹搆搖搾撐攷敗敺斃旂晉暢朧柵榮槃槼檁檾欽歿毀毧毬氂氾汙沒涖淥淵滅滎潁潛潟澂濶災炤煇煢熒熲燐營燿牋牐犖獲玨琍琯瑤瑩甖疊痠盪眎眥矽硶祕祿禿秈稅穀穎穨節範簑籐籥糸糾紀紂約紅紆紇紈紉紋納紐紓純紕紖紗紘紙級紛紜紝紡細紱紲紳紵紹紺紼紿絀終組絆絎結絕絛絝絞絡絢給絰統絳絹綁綃綆綈綉綌綏經綜綞綠綢綣綫綬維綯綰綱網綳綴綸綹綺綻綽綾綿緄緇緋緍緒緓緔緗緘緙緝緞締緣緦編緩緬緯緱緲練緶緹緻緼縈縉縊縋縐縑縗縛縝縞縟縫縭縮縱縲縴縵縷縹繅繆繈繒織繕繙繚繞繢繩繪繭繮繯繰繳繹繼繽繾纇纈纊續纏纓纘纜缽罵羋羶耡聞脈脫舖舘艸蔴蛻裏見覎覓覘覡覥覦覬覯覰覲覺覽覿觀訁訂訃計訊訌討訐訒訓訕訖記訛訝訟訣訥訦訩訪設許訴訶診証詁詆詎詐詒詔評詖詗詘詛詞詡詢詣試詩詫詬詭詮詰話該詳詵詼詿誄誅誆認誑誒誕誘誚語誠誡誣誤誥誦誨說誰課誶誹誼調諂諄談諉請諍諏諑諒論諗諛諜諝諞諡諢諤諦諧諫諭諱諳諷諸諺諼諾謀謁謂謅謊謎謐謔謖謗謙講謝謠謨謫謬謳謹謾譎譏譖識譙譚譜譫譯議譴譸譾讀讎讒讓讕讖讚讜讞貝貞貟負財貢貧貨販貪貫責貯貰貲貳貴貶貸貺費貼貽貿賀賁賂賃賄賅資賈賊賍賑賒賕賙賚賜賞賠賡賢賤賦賧質賫賬賭賮賴賵賺賻購賽賾贄贅贇贈贋贍贏贔贖贛跡車軋軌軑軒軔軛軟軤軫軲軸軹軺軻軼軾較輅輇輈載輊輒輔輕輛輜輞輟輥輦輩輪輬輯輳輸輻輼輾轄轅轆轉轍轎轔轟轡轢轤迆遙酧釓釔釕釗釘釙針釣釤釧釩釵釷釹釺鈀鈁鈃鈄鈈鈉鈍鈎鈐鈑鈒鈔鈕鈞鈡鈣鈥鈦鈧鈮鈰鈳鈴鈷鈸鈹鈺鈽鈾鈿鉀鉄鉆鉈鉉鉍鉑鉕鉗鉚鉛鉞鉦鉬鉭鉲鉶鉸鉺鉻鉿銀銃銅銍銑銓銖銘銚銛銠銣銥銦銨銩銪銫銬銱銳銷銹銻銼鋁鋂鋃鋅鋇鋌鋏鋒鋙鋜鋝鋟鋣鋥鋦鋨鋩鋮鋯鋰鋱鋶鋸鋼錁錆錇錈錏錐錒錕錘錙錚錛錟錠錡錢錦錨錩錫錮錯錳錸錼鍀鍁鍃鍆鍇鍈鍋鍍鍔鍘鍚鍛鍠鍤鍥鍩鍫鍰鍵鍶鍺鎂鎄鎊鎔鎖鎘鎛鎡鎢鎦鎧鎩鎪鎬鎮鎰鎲鎳鎵鎸鏃鏈鏌鏍鏐鏑鏗鏘鏜鏝鏞鏡鏢鏤鏰鏵鏷鏹鐃鐋鐐鐒鐓鐔鐙鐝鐠鐧鐨鐮鐳鐶鐸鐺鐿鑄鑊鑌鑔鑕鑞鑠鑣鑥鑭鑱鑲鑷鑹鑼長門閂閃閆閈閉閌閎閏閑間閔閙閡閣閥閨閩閫閬閭閱閶閹閻閼閽閾閿闃闈闋闌闍闐闒闓闔闕闖闞闠闡闤闥雞靭鞀韋韍韓韙韜韞頁頂頃項順頇須頊頌頎頏預頑頒頓頗領頜頡頤頦頮頰頲頴頷頸頻顆題額顎顏顒顓顙顛顢顥顧顫顬顰顱顳顴風颭颮颯颶颸颻颼飀飃飆飛飢飣飥飩飪飫飭飯飲飴飼飽飾飿餃餄餅餉餌餎餏餑餒餓餕餖餛餜餞餡餳餶餷餺餼餽餾餿饁饃饅饈饉饊饌饒饞饢馬馭馱馳馴馹駁駐駑駒駔駕駘駙駛駝駟駢駭駰駱駸駿騁騂騅騌騍騎騏騐騖騗騣騤騫騭騮騶騷騸騾驁驂驃驄驊驌驍驏驕驛驟驢驤驥驦驪驫骾髩魚魛魢魨魯魴魷魺鮁鮃鮊鮋鮌鮍鮎鮐鮑鮒鮓鮚鮜鮞鮦鮪鮫鮭鮮鮳鮶鮷鮺鯇鯉鯊鯒鯔鯕鯖鯗鯛鯝鯡鯢鯤鯧鯨鯪鯫鯰鯴鯵鯽鯿鰁鰂鰃鰈鰉鰌鰏鰐鰒鰓鰛鰜鰟鰠鰣鰥鰨鰩鰭鰱鰲鰳鰵鰷鰹鰻鰼鰾鱂鱅鱈鱉鱒鱓鱖鱗鱘鱝鱟鱠鱣鱤鱧鱨鱭鱯鱸鱺鳥鳩鳲鳴鳶鴆鴇鴉鴒鴕鴛鴝鴞鴟鴣鴦鴨鴬鴯鴰鴴鴻鴿鵂鵃鵐鵑鵒鵓鵜鵝鵠鵡鵪鵬鵮鵯鵲鵷鵾鶇鶉鶊鶓鶖鶘鶚鶡鶥鶩鶬鶲鶴鶹鶺鶻鶼鶿鷁鷂鷊鷓鷖鷗鷙鷚鷥鷦鷫鷯鷲鷳鷸鷹鷺鸇鸌鸏鸕鸘鸚鸛鸝鸞鹺麥麩黃黽黿鼂鼉鼴齊齏齒齔齕齗齙齜齟齠齡齦齪齬齲齷龍龔龕龜萬與醜專業叢東絲兩嚴喪個爿豐臨為麗舉麼義烏樂喬習鄉書買亂爭於虧雲亙亞產畝親褻嚲億僅從侖倉儀們價眾優夥會傴傘偉傳傷倀倫傖偽佇體餘傭僉俠侶僥偵側僑儈儕儂儔儼倆儷儉債傾傯僂僨償儻儐儲儺兒兗黨蘭關興茲養獸囅岡寫軍農塚馮衝決況凍淨淒涼淩減湊凜幾鳳鳧憑凱擊氹鑿芻劃劉則剛創刪剗剄劊劌剴劑剮劍劇勸辦務勱動勵勁勞勢勳猛勩匭匱區醫華協單賣盧鹵臥衛卻巹廠廳曆厲壓厭厙廁廂厴廈廚廄廝縣參靉靆雙發變敘葉號歎嘰籲後嚇呂嗎唚噸聽啟嘸囈嘔嚦唄員咼嗆嗚詠哢嚨嚀噝噅鹹呱響啞噠嘵嗶噦嘩噲嚌噥喲嘜嗊嘮啢嗩喚呼嘖嗇囀齧囉嘽嘯噴嘍嚳囁嗬噯噓嚶囑嚕劈囂團園圍圇圖圓聖壙場阪壞塊堅壇壢壩塢墳墜壟壚壘墾堊墊埡墶壋塏堖塒塤堝塹墮壪牆壯聲殼壺壼複夠頭誇夾奪奐奮獎奧妝婦媽嫵嫗媯薑婁婭嬈嬌孌媧嫻嫿嬰嬋嬸媼嬡嬪嬙孫學孿寧寶實寵審憲宮寬賓寢對尋導將爾屍層屭屜屬屢屨嶼歲豈嶇崗峴嶴嵐島嶺嶽崠巋嶨嶧峽嶢嶠崢巒嶗崍嶮嶄嶸嶔嶁脊巔鞏巰幣帥師幃帳簾幟帶幀幫幬幘幗襆廣莊慶廬廡庫應廟龐廢廎開異棄張彌弳彎彈歸錄彠徹徑徠禦憶懺憂愾懷態慫憮慪悵愴憐總懟懌戀懇慟懨愷惻惱惲愨懸慳憫驚懼慘懲憊愜慚憚慣湣慍憤憒願懾憖怵懣戇戔戲戧戰紮撲擴捫掃揚擾撫拋摶摳掄搶護擔擬攏揀擁攔擰撥擇掛摯攣掗撾撻挾撓擋撟掙擠揮撏撈損撿換搗據撚擄摑擲撣摻摜摣攬撳攙擱摟攪攜攝攄擺擯攤攖攆擷擼攛擻敵斂數齋斕鬥斬斷無舊時曠暘曇晝曨顯曬曉曄暈暉暫曖術樸機殺雜權條楊榪極樅樞棗櫪梘棖槍楓梟櫃檸檉梔標棧櫛櫳棟櫨櫟欄樹棲樣欒棬椏橈楨檔榿橋樺檜槳樁檮棶檢欞槨槧欏橢樓欖櫬櫚櫸檟檻檳櫧橫檣櫻櫫櫥櫓櫞簷歟歐殲殤殘殞殮殫殯毆轂畢氈毿氌氣氫氬氳漢湯洶遝溝灃漚瀝淪滄渢溈滬濔濘淚澩瀧瀘濼瀉潑澤涇潔灑窪浹淺漿澆湞溮濁測澮濟瀏滻渾滸濃潯濜湧濤澇淶漣潿渦溳渙滌潤澗漲澀澱漬漸澠漁瀋滲溫遊灣濕潰濺漵漊潷滾滯灩灄滿瀅濾濫灤濱灘澦瀠瀟瀲濰瀦瀾瀨瀕灝燈靈燦煬爐燉煒熗點煉熾爍爛烴燭煙煩燒燁燴燙燼熱煥燜燾煆糊溜爺牘牽犧犢狀獷獁猶狽麅獮獰獨狹獅獪猙獄猻獫獵獼玀豬貓蝟獻獺璣璵瑒瑪瑋環現瑲璽瑉琺瓏璫琿璡璉瑣瓊璦璿瓔瓚甕甌電畫疇癤療瘧癘瘍鬁瘡瘋皰屙癰痙癢瘂癆瘓癇癡癉瘮瘞瘺癟癱癮癭癩癬癲臒皚皺皸盞鹽監蓋盜瞘矓著睜睞瞼瞞矚矯磯礬礦碭碼硨硯碸礪礱礫礎硜碩硤磑礄確鹼礙磧镟禮禕禰禎禱禍稟禪離稈種積稱穢穠穭穌穩穡窮竊竅窯竄窩窺竇窶豎競篤筍筆筧籠籩築篳篩簹箏籌簽簡籙簀篋籜籮簞簫簣簍籃籬籪籟糴類糶糲粵糞糧糝餱緊縶線罰罷羆羈羥羨翹翽翬耮耬聳聶聾職聹聯聵聰肅腸膚膁腎腫脹脅膽腖臚脛膠膾髒臍腦膿臠腳腡臉臘醃膕齶膩靦膃騰臏臢輿艤艦艙艫艱豔藝薌蕪蘆蓯葦藶莧萇蒼苧蘋莖蘢蔦荊薦薘莢蕘蓽蕎薈薺葷蕁藎蓀蕒葒葤藥蓧萊蓮蒔萵薟蕕鶯蓴蘀蘿螢蕭薩蔥蕆蕢蔣蔞藍薊蘺蕷鎣驀薔蘞藺藹蘄蘊藪槁蘚虜虛蟲虯蟣雖蝦蠆蝕蟻螞蠶蠔蜆蠱蠣蟶蠻蟄蛺蟯螄蠐蝸蠟蠅蟈蟬蠍螻蠑螿蟎蠨釁補襯袞襖褘襪襲襏裝襠褌褳襝褲襇褸襤觴觸觶讋譽謄諮豶赬趙趕趨趲躉躍蹌蹠躒踐躂蹺蹕躚躋踴躊蹤躓躑躡蹣躕躥躪躦軀辭辯辮邊遼達遷過邁運還這進遠違連遲邇逕適選遜遞邐邏遺鄧鄺鄔郵鄒鄴鄰鬱郤郟鄶鄭鄆酈鄖鄲醞醱醬釅釃釀釋钜鑒鑾鏨鍾鬮鬩隊陽陰陣際陸隴陳陘陝隉隕險隨隱隸雋難雛靂霧霽黴靄靚靜靨韃鞽韉韝韻颺饗饜髏髖髕魘魎黌黶黷黲齇誌製隻鬆麵準拚";
    private final static char[] traditionalChars;
    private final static char[] traditionalChars2;

    static {
        if (simplifiedChar.length() != traditionalChar.length()) {
            throw new IllegalArgumentException();
        }

        {
            simplifiedChars = simplifiedChar.toCharArray();
            Arrays.sort(simplifiedChars);
            traditionalChars2 = new char[simplifiedChars.length];

            for (int i = 0; i < simplifiedChars.length; i++) {
                traditionalChars2[i] = traditionalChar.charAt(simplifiedChar.indexOf(simplifiedChars[i]));
            }
        }

        {
            traditionalChars = traditionalChar.toCharArray();
            Arrays.sort(traditionalChars);
            simplifiedChars2 = new char[traditionalChars.length];

            for (int i = 0; i < traditionalChars.length; i++) {
                simplifiedChars2[i] = simplifiedChar.charAt(traditionalChar.indexOf(traditionalChars[i]));
            }
        }

        if (!toTraditional(simplifiedChar).equals(traditionalChar)) {
            throw new IllegalArgumentException();
        }

        if (!toTraditional(traditionalChar).equals(traditionalChar)) {
            throw new IllegalArgumentException();
        }

        if (!toSimplified(simplifiedChar).equals(simplifiedChar)) {
            throw new IllegalArgumentException();
        }

        if (!toSimplified(traditionalChar).equals(simplifiedChar)) {
            throw new IllegalArgumentException();
        }
    }

    // 转繁体
    public static String toTraditional(String str) {
        char[] cs = str.toCharArray();

        int w;
        for (int i = 0; i < cs.length; i++) {
            if ((w = Arrays.binarySearch(simplifiedChars, cs[i])) >= 0) {
                cs[i] = traditionalChars2[w];
            }
        }

        return new String(cs);
    }

    // 转简体
    public static String toSimplified(String str) {
        char[] cs = str.toCharArray();

        int w;
        for (int i = 0; i < cs.length; i++) {
            if ((w = Arrays.binarySearch(traditionalChars, cs[i])) >= 0) {
                cs[i] = simplifiedChars2[w];
            }
        }

        return new String(cs);
    }
    
    /**
     * <p>
     * 使用opencc开源项目进行简繁体转换<br>
     * 说明：<br>
     * 默认使用“简体->繁体”转换方式<br>
     * </p>
     * @param content
     * 				需要转换的内容
     * @return
     */
    public static String convertByOpencc(String content){
    	return convertByOpencc(content, ConvertType.S2T);
    }
    
    /**
     * <p>
     * 使用opencc开源项目进行简繁体转换<br>
     * 说明:<br>
     * 1、调用http转换接口进行内容转换<br>
     * 2、服务调用失败则用回原方法转换<br>
     * 注意:<br>
     * 此方法暂时只用于给企业发送邮件业务
     * </p>
     * @param content
     * 				需要转换的内容
     * @param convertType
     * 				转换方式
     * @return
     */
    public static String convertByOpencc(String content, ConvertType convertType){
    	String convertContent = StringUtils.EMPTY;
    	if(StringUtils.isNotBlank(content)){
    		Gson gson = new Gson();
    		CloseableHttpClient httpClient = HttpClients.createDefault();
    		HttpPost httpPost = new HttpPost(ServerConfigLoader.getConfigByName(ServerConfig.API_OPENCC_URL));
    		assembleConvertParam(httpClient, httpPost, convertType, content);
			try{
    			HttpResponse response = httpClient.execute(httpPost);
    			HttpEntity entity = response.getEntity();
    			if (entity != null) {
    				String jsonStr = EntityUtils.toString(entity, "utf-8");
    				ChineseConvertResult result = gson.fromJson(jsonStr, ChineseConvertResult.class);
    				if(result.isSuccess()){
    					convertContent = result.getContent();
    				}else{
    					logger.error("chinese convert fail:" + result.getMessage());
    				}
    			}
    			httpPost.releaseConnection();
    			httpPost = null;
    		}catch(Exception e){
    			e.printStackTrace();
    			logger.error("chinese convert exception:" + e.getMessage(), e);
    		}finally{
    			try {
    				httpClient.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
			
			gson = null;
			if(StringUtils.isBlank(convertContent)){
				convertContent = convertByCharDic(content, convertType);
			}
    	}
    	return convertContent;
    }
    
    /**
     * <p>
     * 通过字库进行简繁体转换<br>
     * </p>
     * @param content
     * 				需要转换的内容
     * @param convertType
     * 				转换方式
     * @return
     */
    public static String convertByCharDic(String content, ConvertType convertType){
		switch(convertType){
			case S2T: return toTraditional(content);
			case T2S: return toSimplified(content);
			default : return content;
		}
    }
    
    /**
     * <p>
     * 封装opencc接口调用需要的参数
     * </p>
     * @param httpClient
     * 				模拟客户端
     * @param httpPost
     * 				模拟POST请求
     * @param convertType
     * 				转换方式
     * @param content
     * 				需要转换的内容
     */
    private static void assembleConvertParam(HttpClient httpClient, HttpPost httpPost, ConvertType convertType, String content){
    	String authKey = ServerConfigLoader.getConfigByName(ServerConfig.API_OPENCC_AUTH_KEY);
		String authPass = ServerConfigLoader.getConfigByName(ServerConfig.API_OPENCC_AUTH_PASS);
		
		List<NameValuePair> paramList = Lists.newArrayList();
		paramList.add(new BasicNameValuePair("authToken", MD5Builder.md5(authKey, authPass)));
		paramList.add(new BasicNameValuePair("ctype", convertType.getName()));
		paramList.add(new BasicNameValuePair("content", content));
		httpPost.setEntity(new UrlEncodedFormEntity(paramList, Consts.UTF_8));
    }

}