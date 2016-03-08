import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

@GrailsPlugin(name='adminlte-ui', version='0.1.0')
class gsp_adminlteUi_adminlte_tmpl_littleDropdown_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/plugins/adminlte-ui-0.1.0/grails-app/views/adminlte_tmpl/_littleDropdown.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()

if(comment) {

printHtmlPart(0)
expressionOut.print(comment.encodeAsHTML())
printHtmlPart(1)

}

printHtmlPart(2)
expressionOut.print(liClass)
printHtmlPart(3)
expressionOut.print(faIcon)
printHtmlPart(4)
expressionOut.print(label)
printHtmlPart(5)
expressionOut.print(number ?: '0')
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1410143384000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
