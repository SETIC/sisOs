import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sisOs_ordemDeServicocadastrarOrdemDeServico_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ordemDeServico/cadastrarOrdemDeServico.gsp" }
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
createTagBody(2, {->
printHtmlPart(9)
invokeTag('textField','g',49,['class':("form-control"),'placeholder':("Telefone"),'name':("telefone"),'value':("")],-1)
printHtmlPart(10)
invokeTag('textField','g',61,['type':("email"),'class':("form-control"),'placeholder':("E-mail"),'id':("email"),'name':("email"),'value':(""),'required name':("email"),'onblur':("validaEMAIL(email)")],-1)
printHtmlPart(11)
for( _it388391529 in (orgao) ) {
changeItVariable(_it388391529)
printHtmlPart(12)
expressionOut.print(it.id)
printHtmlPart(13)
expressionOut.print(it.nome)
printHtmlPart(14)
}
printHtmlPart(15)
})
invokeTag('form','g',89,['controller':("ordemDeServico"),'action':("salvarOrdemDeServico"),'class':("form-horizontal")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',90,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1465906526761L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
