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
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("public")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('link','g',21,['controller':("UsuariosOs"),'action':("logout"),'class':("badge")],2)
printHtmlPart(5)
if(true && (ok)) {
printHtmlPart(6)
expressionOut.print(ok)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (erro)) {
printHtmlPart(9)
expressionOut.print(erro)
printHtmlPart(7)
}
printHtmlPart(10)
invokeTag('set','g',65,['var':("i"),'value':(1)],-1)
printHtmlPart(11)
for( _it1908604304 in (ordemDeServico) ) {
changeItVariable(_it1908604304)
printHtmlPart(12)
expressionOut.print(i++)
printHtmlPart(13)
if(true && (it.status.id == 1)) {
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (it.status.id == 2)) {
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (it.status.id == 3)) {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(it.interessado)
printHtmlPart(20)
invokeTag('formatDate','g',88,['format':("dd/MM/yyyy"),'type':("datetime"),'style':("MEDIUM"),'date':(it.dataEmissao)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',90,['format':("dd/MM/yyyy"),'type':("date"),'style':("MEDIUM"),'date':(it.dataAgendamento)],-1)
printHtmlPart(22)
expressionOut.print(it.orgao.nome)
printHtmlPart(19)
expressionOut.print(it.telefone)
printHtmlPart(23)
expressionOut.print(it.id)
printHtmlPart(24)
expressionOut.print(it.id)
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1466004765327L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
