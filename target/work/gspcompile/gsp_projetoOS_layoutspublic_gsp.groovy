import java.lang.System
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_projetoOS_layoutspublic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/public.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("UTF-8")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',9,['default':("Sistema de solicitação de chamados . Painel")],-1)
})
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(3)
expressionOut.print(resource(dir: 'css', file: 'bootstrap.css'))
printHtmlPart(4)
expressionOut.print(resource(dir: 'font-awesome-4.1.0/css', file: 'font-awesome.min.css'))
printHtmlPart(5)
expressionOut.print(resource(dir: 'css', file: 'ionicons.min.css'))
printHtmlPart(6)
expressionOut.print(resource(dir: 'css', file: 'morris/morris.css'))
printHtmlPart(7)
expressionOut.print(resource(dir: 'css', file: 'jvectormap/jquery-jvectormap-1.2.2.css'))
printHtmlPart(8)
expressionOut.print(resource(dir: 'css', file: 'daterangepicker/daterangepicker-bs3.css'))
printHtmlPart(9)
expressionOut.print(resource(dir: 'css', file: 'bootstrap-select.css'))
printHtmlPart(10)
expressionOut.print(resource(dir: 'css', file: 'dataTables.bootstrap.css'))
printHtmlPart(11)
expressionOut.print(resource(dir: 'css', file: 'AdminLTE.min.css'))
printHtmlPart(12)
expressionOut.print(resource(dir: 'css', file: 'style-form-wizard.css'))
printHtmlPart(13)
expressionOut.print(resource(dir: 'css', file: 'jasny-bootstrap.min.css'))
printHtmlPart(14)
expressionOut.print(resource(dir: 'css', file: 'bootstrap-modal-master/css/bootstrap-modal.css'))
printHtmlPart(15)
expressionOut.print(resource(dir: 'css', file: 'skins/_all-skins.min.css'))
printHtmlPart(16)
expressionOut.print(resource(dir: 'css', file: 'bootstrap-modal-master/css/bootstrap-modal.css'))
printHtmlPart(17)
invokeTag('javascript','g',113,['src':("jQuery/jQuery-2.1.3.min.js")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',114,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(18)
invokeTag('img','g',129,['dir':("images"),'file':("setic.png"),'class':("img-responsive"),'alt':("Secretaria de tecnologia"),'style':("height: 100px; margin-left: 15%; margin-top: -70px;")],-1)
printHtmlPart(19)
invokeTag('img','g',132,['dir':("images"),'file':("sga.png"),'class':("img-responsive"),'alt':("Prefeitura de São Gonçalo do Amarante"),'style':("height: 100px; float: right; margin-top: -99px;margin-right: 15%;")],-1)
printHtmlPart(20)
invokeTag('layoutBody','g',139,[:],-1)
printHtmlPart(21)
invokeTag('javascript','g',156,['src':("bootstrap.js")],-1)
printHtmlPart(22)
invokeTag('javascript','g',158,['src':("jasny-bootstrap.min.js")],-1)
printHtmlPart(23)
invokeTag('javascript','g',160,['src':("plugins/fastclick/fastclick.min.js")],-1)
printHtmlPart(24)
invokeTag('javascript','g',162,['src':("app.min.js")],-1)
printHtmlPart(25)
invokeTag('javascript','g',164,['src':("script-form-wizard.js")],-1)
printHtmlPart(26)
invokeTag('javascript','g',166,['src':("jquery.dataTables.min.js")],-1)
printHtmlPart(27)
invokeTag('javascript','g',168,['src':("dataTables.bootstrap.js")],-1)
printHtmlPart(28)
invokeTag('javascript','g',170,['src':("dataScript.js")],-1)
printHtmlPart(29)
invokeTag('javascript','g',172,['src':("dist/js/bootstrap-select.js")],-1)
printHtmlPart(30)
invokeTag('javascript','g',174,['src':("plugins/sparkline/jquery.sparkline.min.js")],-1)
printHtmlPart(31)
invokeTag('javascript','g',176,['src':("plugins/jvectormap/jquery-jvectormap-1.2.2.min.js")],-1)
printHtmlPart(32)
invokeTag('javascript','g',178,['src':("plugins/jvectormap/jquery-jvectormap-world-mill-en.js")],-1)
printHtmlPart(33)
invokeTag('javascript','g',180,['src':("plugins/daterangepicker/daterangepicker.js")],-1)
printHtmlPart(34)
invokeTag('javascript','g',182,['src':("plugins/datepicker/bootstrap-datepicker.js")],-1)
printHtmlPart(35)
invokeTag('javascript','g',184,['src':("plugins/iCheck/icheck.min.js")],-1)
printHtmlPart(36)
invokeTag('javascript','g',186,['src':("plugins/slimScroll/jquery.slimscroll.min.js")],-1)
printHtmlPart(37)
invokeTag('javascript','g',188,['src':("plugins/chartjs/Chart.min.js")],-1)
printHtmlPart(38)
invokeTag('javascript','g',190,['src':("bootstrap-modal-master/js/bootstrap-modal.js")],-1)
printHtmlPart(38)
invokeTag('javascript','g',192,['src':("bootstrap-modal-master/js/bootstrap-modalmanager.js")],-1)
printHtmlPart(39)
invokeTag('javascript','g',195,['src':("dashboard2.js")],-1)
printHtmlPart(40)
invokeTag('javascript','g',198,['src':("demo.js")],-1)
printHtmlPart(41)
})
invokeTag('captureBody','sitemesh',199,['class':("skin-blue row")],1)
printHtmlPart(42)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1457008229529L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
