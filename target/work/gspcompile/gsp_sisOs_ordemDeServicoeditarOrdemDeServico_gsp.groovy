import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sisOs_ordemDeServicoeditarOrdemDeServico_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ordemDeServico/editarOrdemDeServico.gsp" }
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
printHtmlPart(6)
for( _it154543987 in (ordemDeServico) ) {
changeItVariable(_it154543987)
printHtmlPart(6)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('hiddenField','g',34,['type':("number"),'name':("id"),'value':(it.id)],-1)
printHtmlPart(10)
expressionOut.print(it.interessado)
printHtmlPart(11)
expressionOut.print(it.matricula)
printHtmlPart(12)
invokeTag('textField','g',57,['class':("form-control"),'name':("telefone"),'disabled value':(it.telefone)],-1)
printHtmlPart(13)
invokeTag('textField','g',67,['class':("form-control"),'name':("telefone"),'disabled value':(it.dataEmissao)],-1)
printHtmlPart(14)
invokeTag('textField','g',74,['class':("form-control"),'name':("email"),'disabled value':(it.email)],-1)
printHtmlPart(15)
invokeTag('textField','g',83,['class':("form-control"),'name':("orgao"),'disabled value':(it.orgao.nome)],-1)
printHtmlPart(16)
expressionOut.print(it.problema)
printHtmlPart(17)
for( _it1113060286 in (status) ) {
changeItVariable(_it1113060286)
printHtmlPart(18)
if(true && (it.id == ordemDeServico.status.id)) {
printHtmlPart(19)
expressionOut.print(it.id)
printHtmlPart(20)
expressionOut.print(it.nome)
printHtmlPart(21)
}
else {
printHtmlPart(19)
expressionOut.print(it.id)
printHtmlPart(22)
expressionOut.print(it.nome)
printHtmlPart(21)
}
printHtmlPart(23)
}
printHtmlPart(24)
})
invokeTag('form','g',137,['controller':("ordemDeServico"),'action':("atualizar"),'class':("form-horizontal")],2)
printHtmlPart(25)
})
invokeTag('captureBody','sitemesh',138,[:],1)
printHtmlPart(26)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1457539478362L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
