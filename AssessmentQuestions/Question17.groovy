/**
 * Created by robertobrien on 19/09/2016.
 */
import groovy.xml.MarkupBuilder

def writer = new StringWriter()
        def html = new MarkupBuilder(writer)

        def file = new File("townDescription.rtf")

        html.html {
            head {
                title 'Carrick-on-Suir, Co. Tipperary'
            }
            body(id: 'main') {
                h1 'Town Description'
                file.eachLine { line ->
                    p line
                }
                br()
            }
            h1 'Carrick-on-Suir Restaurants'
            a href: 'http://www.carraighotel.com/', 'Carraig Restaurant'
            a href: 'http://www.lilymais.com/', 'Lily Mais Restaurant'
            br()
            h1 'Pictures of Carrick-on-Suir'
            new File("/Users/robertobrien/Workspace/GroovyQuestions/src").eachFileMatch(~/.*.jpg/) { f ->
                image f.getName()
                br()
            }

        }

 println writer