import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='platform-core', version='1.0.0')
class gsp_platformCore_layouts_platformdev_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/platform-core-1.0.0/grails-app/views/layouts/platform/dev.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('layoutHead','g',4,[:],-1)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('require','r',6,['module':("plugin.platformCore.tools")],-1)
printHtmlPart(2)
invokeTag('layoutResources','r',7,[:],-1)
printHtmlPart(1)
})
invokeTag('isAvailable','plugin',8,['name':("resources")],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',14,['class':("brand"),'controller':("platformTools")],2)
printHtmlPart(6)
invokeTag('primary','nav',15,['class':("nav"),'scope':("dev")],-1)
printHtmlPart(7)
invokeTag('layoutBody','g',21,[:],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(2)
invokeTag('layoutResources','r',25,[:],-1)
printHtmlPart(1)
})
invokeTag('isAvailable','plugin',26,['name':("resources")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',27,[:],1)
printHtmlPart(9)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1457455115200L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
