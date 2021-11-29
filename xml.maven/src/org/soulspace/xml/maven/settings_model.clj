(ns org.soulspace.xml.maven.settings-model
  )


(defn parse-plugin-groups
  ""
  [zipper])

(defn parse-mirrors
  ""
  [zipper])

(defn parse-servers
  ""
  [zipper]
  )

(defn parse-proxies
  ""
  [zipper])

(defn parse-profiles
  ""
  [zipper])

(defn parse-active-profiles
  ""
  [zipper])


(defn parse-settings
  "Parse the settings xml from the given zipper."
  [zipper]
  (let [local-repository (zx/xml1-> zipper :localRepository zx/text)
        interactive-mode (zx/xml1-> zipper :interactiveMode zx/text)
        offline (zx/xml1-> zipper :offline zx/text)
        plugin-groups (parse-plugin-groups (zx/xml1-> zipper :pluginGroups))
        servers (parse-servers (zx/xml1-> zipper :servers))
        mirrors (parse-mirrors (zx/xml1-> zipper :mirrors))
        proxies (parse-proxies (zx/xml1-> zipper :proxies))
        profiles (parse-profiles (zx/xml1-> zipper :profiles))
        active-profiles (parse-active-profiles (zx/xml1-> zipper :activeProfiles))]
    (SettingsImpl. local-repository interactive-mode offline plugin-groups servers mirrors proxies profiles active-profiles)))