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
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(4, 2)
invokeTag('link','g',20,['controller':("Layout"),'action':("index")],2)
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',21,['controller':("OrdemDeServico"),'action':("listarOrdemDeServico")],2)
printHtmlPart(5)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',23,['controller':("OrdemDeServico"),'action':("cadastrarOrdemDeServico")],2)
printHtmlPart(8)
if(true && (ok)) {
printHtmlPart(9)
expressionOut.print(ok)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (erro)) {
printHtmlPart(12)
expressionOut.print(erro)
printHtmlPart(10)
}
printHtmlPart(13)
invokeTag('set','g',64,['var':("i"),'value':(1)],-1)
printHtmlPart(14)
for( _it1996147078 in (ordemDeServico) ) {
changeItVariable(_it1996147078)
printHtmlPart(15)
expressionOut.print(i++)
printHtmlPart(16)
if(true && (it.status.id == 1)) {
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (it.status.id == 2)) {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (it.status.id == 3)) {
printHtmlPart(21)
}
printHtmlPart(22)
expressionOut.print(it.interessado)
printHtmlPart(23)
invokeTag('formatDate','g',90,['format':("dd/MM/yyyy"),'type':("datetime"),'style':("MEDIUM"),'date':(it.dataEmissao)],-1)
printHtmlPart(24)
invokeTag('formatDate','g',92,['format':("dd/MM/yyyy"),'type':("date"),'style':("MEDIUM"),'date':(it.dataAgendamento)],-1)
printHtmlPart(25)
expressionOut.print(it.orgao.nome)
printHtmlPart(22)
expressionOut.print(it.telefone)
printHtmlPart(26)
expressionOut.print(it.id)
printHtmlPart(27)
expressionOut.print(it.id)
printHtmlPart(28)
}
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',116,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1458755099650L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
