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
if(true && (ok)) {
printHtmlPart(4)
expressionOut.print(ok)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (erro)) {
printHtmlPart(7)
expressionOut.print(erro)
printHtmlPart(5)
}
printHtmlPart(8)
invokeTag('set','g',61,['var':("i"),'value':(1)],-1)
printHtmlPart(9)
for( _it1996829900 in (ordemDeServico) ) {
changeItVariable(_it1996829900)
printHtmlPart(10)
expressionOut.print(i++)
printHtmlPart(11)
if(true && (it.status.id == 1)) {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (it.status.id == 2)) {
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (it.status.id == 3)) {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(it.interessado)
printHtmlPart(18)
invokeTag('formatDate','g',84,['format':("dd/MM/yyyy"),'type':("datetime"),'style':("MEDIUM"),'date':(it.dataEmissao)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',86,['format':("dd/MM/yyyy"),'type':("date"),'style':("MEDIUM"),'date':(it.dataAgendamento)],-1)
printHtmlPart(20)
expressionOut.print(it.orgao.nome)
printHtmlPart(17)
expressionOut.print(it.telefone)
printHtmlPart(21)
expressionOut.print(it.id)
printHtmlPart(22)
expressionOut.print(it.id)
printHtmlPart(23)
}
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',117,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1462193557732L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
