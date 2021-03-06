grails.project.work.dir = "target"
grails.project.dependency.resolver = "maven"

grails.project.dependency.distribution = {
	remoteRepository(id: "localPluginReleases", url: "http://localhost:8081/artifactory/plugins-release-local/")
	remoteRepository(id: "localPluginSnapshots", url: "http://localhost:8081/artifactory/plugins-snapshot-local/")
}

grails.project.dependency.resolution = {
	inherits "global"
	log "warn"

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {
		String droolsVersion = "6.2.0.CR4" //"6.1.0.Final"
		String comSunXmlBindVersion = "2.2.11"

		compile "org.drools:drools-compiler:$droolsVersion", {
			excludes "activation", "antlr-runtime", "cdi-api", "drools-core", "ecj", "glazedlists_java15",
			         "gunit", "janino", "junit", "logback-classic", "mockito-all", "mvel2",
			         "org.osgi.compendium", "org.osgi.core", "quartz", "slf4j-api",
			         "stax-api", "weld-se-core", "xstream"
		}
		compile "org.drools:drools-core:$droolsVersion", {
			excludes "activation", "antlr", "antlr-runtime", "cdi-api", "junit", "kie-api", "kie-internal",
			         "logback-classic", "mockito-all", "mvel2", "org.osgi.compendium", "org.osgi.core",
			         "protobuf-java", "slf4j-api", "stax-api", "xstream"    //
		}
		compile "org.drools:drools-decisiontables:$droolsVersion", {
			excludes "commons-io", "drools-compiler", "drools-core", "drools-templates", "junit", "logback-classic",
			         "mockito-all", "org.osgi.compendium", "org.osgi.core", "poi-ooxml", "slf4j-api"
		}
		compile "org.drools:drools-jsr94:$droolsVersion", {
			excludes "drools-compiler", "drools-core", "drools-decisiontables", "jsr94", "jsr94-sigtest",
			         "jsr94-tck", "junit", "mockito-all"
		}
		compile "org.drools:drools-verifier:$droolsVersion", {
			excludes "drools-compiler", "guava", "itext", "junit", "kie-api", "mockito-all", "xstream"
		}
		compile "org.kie:kie-api:$droolsVersion", {
			excludes "activation", "cdi-api", "jms", "junit", "mockito-all", "org.osgi.compendium",
			         "org.osgi.core", "quartz", "slf4j-api", "stax-api", "xstream"
		}
		compile "org.kie:kie-internal:$droolsVersion", {
			excludes "cdi-api", "junit", "kie-api", "mockito-all", "slf4j-api", "xstream"
		}

		// TODO replace the rest with this and excludes?
		compile "org.kie:kie-spring:$droolsVersion"

		/*
		<groupId>org.jbpm</groupId>
		<artifactId>jbpm-flow</artifactId>

		<groupId>org.springframework</groupId>
		<artifactId>spring-tx</artifactId>

		<groupId>org.kie</groupId>
		<artifactId>kie-api</artifactId>

		<groupId>org.kie</groupId>
		<artifactId>kie-internal</artifactId>

		<groupId>org.drools</groupId>
		<artifactId>drools-core</artifactId>

		<groupId>org.drools</groupId>
		<artifactId>drools-compiler</artifactId>

		<groupId>org.drools</groupId>
		<artifactId>drools-decisiontables</artifactId>

		<groupId>org.drools</groupId>
		<artifactId>drools-persistence-jpa</artifactId>
		<optional>true</optional>

		<groupId>org.jbpm</groupId>
		<artifactId>jbpm-persistence-jpa</artifactId>
		<optional>true</optional>

		<groupId>org.jbpm</groupId>
		<artifactId>jbpm-human-task-core</artifactId>
		<optional>true</optional>

		<groupId>org.jbpm</groupId>
		<artifactId>jbpm-human-task-jpa</artifactId>
		<optional>true</optional>

		<groupId>org.jbpm</groupId>
		<artifactId>jbpm-runtime-manager</artifactId>
		<optional>true</optional>

		<groupId>com.sun.xml.bind</groupId>
		<artifactId>jaxb-impl</artifactId>
		<scope>provided</scope>

		<groupId>com.sun.xml.bind</groupId>
		<artifactId>jaxb-xjc</artifactId>
		<scope>provided</scope>

		<groupId>org.springframework</groupId>
		<artifactId>spring-core</artifactId>

		<groupId>commons-logging</groupId>
		<artifactId>commons-logging</artifactId>


		<groupId>org.springframework</groupId>
		<artifactId>spring-beans</artifactId>

		<groupId>org.springframework</groupId>
		<artifactId>spring-orm</artifactId>
		<optional>true</optional>

		<groupId>org.springframework</groupId>
		<artifactId>spring-jdbc</artifactId>
		<optional>true</optional>

		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>

		<groupId>org.hibernate.javax.persistence</groupId>
		<artifactId>hibernate-jpa-2.0-api</artifactId>
		<optional>true</optional>

		<groupId>com.thoughtworks.xstream</groupId>
		<artifactId>xstream</artifactId>

		<groupId>org.slf4j</groupId>
		<artifactId>slf4j-api</artifactId>

		<groupId>ch.qos.logback</groupId>
		<artifactId>logback-classic</artifactId>

		<groupId>org.slf4j</groupId>
		<artifactId>jcl-over-slf4j</artifactId>
		<scope>test</scope>

		<groupId>org.kie</groupId>
		<artifactId>kie-ci</artifactId>
		<scope>test</scope>

		<groupId>org.drools</groupId>
		<artifactId>drools-core</artifactId>
		<type>test-jar</type>
		<scope>test</scope>

		<groupId>org.hibernate</groupId>
		<artifactId>hibernate-entitymanager</artifactId>
		<scope>test</scope>

		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<scope>test</scope>

		<groupId>org.codehaus.btm</groupId>
		<artifactId>btm</artifactId>
		<scope>test</scope>

		<groupId>javax.enterprise</groupId>
		<artifactId>cdi-api</artifactId>
		<scope>provided</scope>

		<groupId>org.eclipse.jdt.core.compiler</groupId>
		<artifactId>ecj</artifactId>
		<scope>test</scope>

		<groupId>org.antlr</groupId>
		<artifactId>antlr-runtime</artifactId>
		<scope>test</scope>

		<groupId>org.springframework</groupId>
		<artifactId>spring-test</artifactId>
		<scope>test</scope>

		<groupId>org.drools</groupId>
		<artifactId>named-kiesession</artifactId>
		<scope>test</scope>

		<groupId>org.jbpm</groupId>
		<artifactId>jbpm-audit</artifactId>
		<scope>test</scope>

		<groupId>org.apache.felix</groupId>
		<artifactId>maven-bundle-plugin</artifactId>
		<extensions>true</extensions>
		 */

		runtime "com.sun.xml.bind:jaxb-xjc:$comSunXmlBindVersion", {
			excludes "jaxb-core"
		}
		runtime "com.sun.xml.bind:jaxb-impl:$comSunXmlBindVersion", {
			excludes "FastInfoset", "jaxb-core"
		}

		// TODO find more recent version
		// java.lang.NoClassDefFoundError: org/codehaus/janino/Scanner$ScanException in 2.7.6 and above
		runtime "org.codehaus.janino:janino:2.5.16", {
			excludes "ant-nodeps", "junit"
		}

		runtime "com.thoughtworks.xstream:xstream:1.4.7", {
			excludes "cglib-nodep", "commons-lang", "dom4j", "jdom", "jettison", "jmock", "joda-time",
				"json", "junit", "kxml2", "kxml2-min", "oro", "stax", "stax-api",
				"wstx-asl", "xml-writer", "xmlpull", "xom", "xpp3_min"
		}

		runtime "org.eclipse.jdt.core.compiler:ecj:4.4"

		runtime "org.mvel:mvel2:2.2.2.Final", {
			excludes "junit", "xstream"
		}

		runtime "org.antlr:antlr-runtime:3.5.2", {
			excludes "junit", "stringtemplate"
		}

		//		drools-persistence-jpa-6.0.0.CR5
		//		drools-templates-6.0.0.CR5
		//		bcmail-jdk14-138
		//		bcprov-jdk14-138
		//		dom4j-1.6.1
		//		guava-13.0.1
		//		hibernate-jpa-2.0-api-1.0.1.Final
		//		itext-2.1.2
		//		javassist-3.15.0-GA
		//		jsr94-1.1
		//		poi-3.9
		//		poi-ooxml-3.9
		//		poi-ooxml-schemas-3.9
		//		stax-api-1.0.1
		//		xml-apis-1.3.04
		//		xmlbeans-2.3.0
		//		xmlpull-1.1.3.1
	}

	plugins {
		build ":release:3.0.1", ":rest-client-builder:2.0.3", {
			export = false
		}

		runtime ":hibernate4:4.3.6.1", {
			export = false
		}
	}
}
