(ns org.soulspace.xml.maven.settings-dsl
  (:require [org.soulspace.xml.dsl-builder :as dsl])
  
  )

;;
;; DSL for the Maven settings model 1.o.0
;;
(dsl/deftags "settings" ["activation" "active" "activeByDefault" "activeProfile" "activeProfiles" "arch" "checksumPolicy" "configuration"
                         "directoryPermissions" "enabled" "exists" "family" "file" "filePermissions" "host" "id" "interactiveMode" "jdk" "layout" "localRepository"
                         "mirror" "mirrorOf" "mirrors" "missing" "name" "nonProxyHosts" "offline" "os"
                         "passphrase" "password" "port" "privateKey" "profile" "profiles" "property" "protocol" "proxies" "proxy" "pluginGroup" "pluginGroups"
                        "pluginRepositories" "pluginRepository" "releases" "repositories" "repository" "servers" "server" "snapshots" "updatePolicy" "url" "username" "value" "version"
                         ])

(dsl/defroottags "settings" "http://maven.apache.org/SETTINGS/1.0.0" ["settings"])

