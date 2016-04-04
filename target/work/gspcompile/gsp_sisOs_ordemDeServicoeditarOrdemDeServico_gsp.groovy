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
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("public")],-1)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
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
printHtmlPart(8)
for( _it402697895 in (ordemDeServico) ) {
changeItVariable(_it402697895)
printHtmlPart(8)
}
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('hiddenField','g',38,['type':("number"),'name':("id"),'value':(it.id)],-1)
printHtmlPart(12)
expressionOut.print(it.interessado)
printHtmlPart(13)
expressionOut.print(it.matricula)
printHtmlPart(14)
invokeTag('textField','g',61,['class':("form-control"),'name':("telefone"),'disabled value':(it.telefone)],-1)
printHtmlPart(15)
invokeTag('textField','g',71,['class':("form-control"),'name':("dataEmissao"),'disabled value':(it.dataEmissao.format('dd/MM/yyyy'))],-1)
printHtmlPart(16)
invokeTag('textField','g',78,['class':("form-control"),'name':("email"),'disabled value':(it.email)],-1)
printHtmlPart(17)
invokeTag('textField','g',87,['class':("form-control"),'name':("orgao"),'disabled value':(it.orgao.nome)],-1)
printHtmlPart(18)
expressionOut.print(it.dataAgendamento?.format('dd/MM/yyyy'))
printHtmlPart(19)
expressionOut.print(it.problema)
printHtmlPart(20)
for( _it1422549568 in (status) ) {
changeItVariable(_it1422549568)
printHtmlPart(21)
if(true && (it.id == ordemDeServico.status.id)) {
printHtmlPart(22)
expressionOut.print(it.id)
printHtmlPart(23)
expressionOut.print(it.nome)
printHtmlPart(24)
}
else {
printHtmlPart(22)
expressionOut.print(it.id)
printHtmlPart(25)
expressionOut.print(it.nome)
printHtmlPart(24)
}
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(ordemDeServico.solucao)
printHtmlPart(28)
})
invokeTag('form','g',157,['controller':("ordemDeServico"),'action':("atualizar"),'class':("form-horizontal")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',158,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1458752803615L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
