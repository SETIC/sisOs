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
invokeTag('link','g',22,['controller':("OrdemDeServico"),'action':("listarOrdemDeServico")],2)
printHtmlPart(5)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',24,['controller':("OrdemDeServico"),'action':("cadastrarOrdemDeServico")],2)
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
invokeTag('set','g',65,['var':("i"),'value':(1)],-1)
printHtmlPart(14)
for( _it2126170083 in (ordemDeServico) ) {
changeItVariable(_it2126170083)
printHtmlPart(15)
expressionOut.print(it.id)
printHtmlPart(16)
expressionOut.print(it.id)
printHtmlPart(17)
expressionOut.print(i++)
printHtmlPart(18)
expressionOut.print(it.interessado)
printHtmlPart(19)
expressionOut.print(it.matricula)
printHtmlPart(20)
invokeTag('formatDate','g',96,['format':("dd/MM/yyyy"),'type':("datetime"),'style':("MEDIUM"),'date':(it.dataEmissao)],-1)
printHtmlPart(21)
expressionOut.print(it.email)
printHtmlPart(19)
expressionOut.print(it.orgao.sigla)
printHtmlPart(22)
if(true && (it.status.id == 1)) {
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (it.status.id == 2)) {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (it.status.id == 3)) {
printHtmlPart(27)
}
printHtmlPart(28)
}
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',117,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1457542556617L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
