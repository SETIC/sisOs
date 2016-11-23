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
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("public")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1"),'name':("viewport")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(2)
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
printHtmlPart(7)
for( _it2034564527 in (ordemDeServico) ) {
changeItVariable(_it2034564527)
printHtmlPart(7)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('hiddenField','g',42,['type':("number"),'name':("id"),'value':(it.id)],-1)
printHtmlPart(11)
expressionOut.print(it.matricula)
printHtmlPart(12)
expressionOut.print(it.interessado)
printHtmlPart(13)
invokeTag('textField','g',63,['class':("form-control"),'name':("telefone"),'disabled value':(it.telefone)],-1)
printHtmlPart(14)
invokeTag('textField','g',71,['class':("form-control"),'name':("dataEmissao"),'disabled value':(it.dataEmissao.format('dd/MM/yyyy'))],-1)
printHtmlPart(15)
invokeTag('textField','g',77,['class':("form-control"),'name':("email"),'disabled value':(it.email)],-1)
printHtmlPart(16)
invokeTag('textField','g',84,['class':("form-control"),'name':("orgao"),'disabled value':(it.orgao.nome)],-1)
printHtmlPart(17)
expressionOut.print(it.dataAgendamento?.format('dd/MM/yyyy'))
printHtmlPart(18)
expressionOut.print(it.problema)
printHtmlPart(19)
for( _it543894108 in (status) ) {
changeItVariable(_it543894108)
printHtmlPart(20)
if(true && (it.id == ordemDeServico.status.id)) {
printHtmlPart(21)
expressionOut.print(it.id)
printHtmlPart(22)
expressionOut.print(it.nome)
printHtmlPart(23)
}
else {
printHtmlPart(21)
expressionOut.print(it.id)
printHtmlPart(24)
expressionOut.print(it.nome)
printHtmlPart(23)
}
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(ordemDeServico.solucao)
printHtmlPart(27)
})
invokeTag('form','g',152,['controller':("ordemDeServico"),'action':("atualizar"),'class':("form-horizontal")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',156,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1479833711206L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
