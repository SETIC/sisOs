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
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("public2")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
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
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(erro)
printHtmlPart(12)
invokeTag('textField','g',69,['class':("form-control"),'placeholder':("Digite apenas números"),'id':("telefone"),'name':("telefone"),'value':(""),'onkeypress':("mascara(this,mtel);"),'onblur':("validaTelefone(telefone);"),'maxlength':("10")],-1)
printHtmlPart(13)
expressionOut.print(erro)
printHtmlPart(14)
invokeTag('textField','g',81,['type':("email"),'class':("form-control"),'placeholder':("E-mail"),'id':("email"),'name':("email"),'value':(""),'required':("true"),'onblur':("validaEMAIL(email)")],-1)
printHtmlPart(15)
expressionOut.print(erro)
printHtmlPart(16)
for( _it1380342676 in (orgao) ) {
changeItVariable(_it1380342676)
printHtmlPart(17)
expressionOut.print(it.id)
printHtmlPart(18)
expressionOut.print(it.nome)
printHtmlPart(19)
}
printHtmlPart(20)
})
invokeTag('form','g',121,['name':("ordemDeServico"),'controller':("ordemDeServico"),'action':("salvarOrdemDeServico"),'class':("form-horizontal")],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',125,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1500919005752L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
