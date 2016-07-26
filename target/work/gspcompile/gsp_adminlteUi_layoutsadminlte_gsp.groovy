import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='adminlte-ui', version='0.1.0')
class gsp_adminlteUi_layoutsadminlte_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/adminlte-ui-0.1.0/grails-app/views/layouts/adminlte.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',6,['default':("Grails")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(1)
invokeTag('layoutHead','g',8,[:],-1)
printHtmlPart(1)
invokeTag('require','r',9,['modules':("adminlte-core")],-1)
printHtmlPart(1)
invokeTag('layoutResources','r',10,[:],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',17,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('header','altt',19,[:],-1)
printHtmlPart(4)
invokeTag('sidebar','altt',24,['forceDeep':("true"),'depth':("2")],-1)
printHtmlPart(5)
invokeTag('layoutBody','g',34,[:],-1)
printHtmlPart(6)
invokeTag('layoutResources','r',38,[:],-1)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',39,['class':("skin-blue")],1)
printHtmlPart(7)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1457455113382L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
