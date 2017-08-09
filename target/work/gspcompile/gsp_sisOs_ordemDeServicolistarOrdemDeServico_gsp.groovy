import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sisOs_ordemDeServicolistarOrdemDeServico_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ordemDeServico/listarOrdemDeServico.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("public")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (ok)) {
printHtmlPart(5)
expressionOut.print(ok)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (erro)) {
printHtmlPart(8)
expressionOut.print(erro)
printHtmlPart(6)
}
printHtmlPart(9)
invokeTag('set','g',60,['var':("i"),'value':(1)],-1)
printHtmlPart(10)
for( _it1040765233 in (ordemDeServico) ) {
changeItVariable(_it1040765233)
printHtmlPart(11)
expressionOut.print(it.id)
printHtmlPart(12)
if(true && (it.status.id == 1)) {
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (it.status.id == 2)) {
printHtmlPart(15)
}
printHtmlPart(14)
if(true && (it.status.id == 3)) {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(it.interessado)
printHtmlPart(18)
invokeTag('formatDate','g',81,['format':("dd/MM/yyyy"),'type':("datetime"),'style':("MEDIUM"),'date':(it.dataEmissao)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',83,['format':("dd/MM/yyyy"),'type':("date"),'style':("MEDIUM"),'date':(it.dataAgendamento)],-1)
printHtmlPart(20)
if(true && (it.dataAgendamento == null)) {
printHtmlPart(21)
expressionOut.print('----')
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(it.orgao.nome)
printHtmlPart(24)
expressionOut.print(it.telefone)
printHtmlPart(25)
expressionOut.print(it.id)
printHtmlPart(26)
expressionOut.print(it.id)
printHtmlPart(27)
expressionOut.print(it.id)
printHtmlPart(28)
}
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',118,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1484574061000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
