(ns org.soulspace.clj.xsd.xsd-parser
  (:require [clojure.string :as str]
            [clojure.pprint :as pp]
            [clojure.data.xml :as xml]
            [clojure.walk :as walk]))


; 3.16.7.4 Built-in primitive datatypes
; string, boolean, float, double, decimal, dateTime, duration, time,
; date, gMonth, gMonthDay, gDay, gYear, gYearMonth, hexBinary, base64Binary,
; anyURI, QName and NOTATION

(declare parse-element parse-group parse-sequence parse-simple-type)

(defn print-element [e] (println (dissoc e :_content :_context)))

(def buildin-types #{"xs:string" "xs:boolean" "xs:float" "xs:double" "xs:decimal"
                     "xs:dateTime" "xs:duration" "xs:time" "xs:date"
                     "xs:gMonth" "xs:gMonthDay" "xs:gDay" "xs:gYear" "xs:gYearMonth"
                     "xs:hexBinary" "xs:base64Binary" "xs:anyURI" "xs:QName" "xs:NOTATION"})

(defn attribute?
  "Tests if the entry is an attribute."
  [e]
  (= (:_tag e) :attribute))

(defn attribute-group?
  "Tests if the entry is a attribute group."
  [e]
  (= (:_tag e) :attributeGroup))

(defn element?
  "Tests if the entry is an element."
  [e]
  (= (:_tag e) :element))

(defn group?
  "Tests if the entry is a group."
  [e]
  (= (:_tag e) :group))

(defn simple-type?
  "Tests if the entry is a simple type."
  [e]
  (= (:_tag e) :simpleType))

(defn complex-type?
  "Tests if the entry is a complex type."
  [e]
  (= (:_tag e) :complexType))

(defn simple-element?
  "Tests if the entry is an element of type simple."
  [e]
  ; TODO check correct condition
  (and (element? e) (or (contains? buildin-types (:type e))
                        (seq (filter simple-type? (:_content e))))))

(defn complex-element?
  "Tests if the entry is an element of type complex."
  [e]
  ; TODO check correct condition
  (and (element? e) (or (not (contains? buildin-types (:type e)))
                        (seq (filter complex-type? (:_content e))))))

(defn element-ref?
  "Tests if the entry is an element reference."
  [e]
  ; TODO check correct condition
  (and (element? e) (:ref e)))

(defn ref?
  "Tests if the entry has a ref attribure."
  [e]
  (:ref e))

(defn named?
  "Tests if the entry has a name attribute."
  [e]
  (:name e))

(defn typed?
  "Tests if the entry has a type attribute."
  [e]
  (:type e))

(defn identified?
  "Tests if the entry has an id attribute."
  [e]
  (:id e))

(defn optional?
  "Tests if the entry is optional."
  [e]
  (= (:minOccurs e) "0"))

(defn mandatory?
  "Tests if the entry is  mandatory."
  [e]
  (not= (:minOccurs e) "0"))

(defn unbounded?
  "Tests if the cardinality of the entry is unbounded."
  [e]
  (= (:maxOccurs e) "unbounded"))


(defn context-map
  "Returns a context map of named elements for the entry."
  [e]
  (->> (:_content e)
       (filter named?)
       (into {} (map (fn [x] [(:name x) x])))))

; TODO not needed here
(defn get-content
  "Returns the content, when tag of the entry maches the given tag."
  [tag entry]
  (when (= (:tag entry) tag)
    (:content entry)))

(defn parse-documentation
  "Parses a XML schema documentation"
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (merge attrs {:_tag tag :_content (first content)})))

(defn parse-annotation-content
  "Parses an XML schema annotation content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :documentation)
      (parse-documentation element)
      :default
      (println "WARN: Unhandled tag in annotation-content:" tag attrs))))

(defn parse-annotation
  "Parses an XML schema annotation."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-annotation-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-any-content
  "Parses an XML schema any content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in any-content:" tag attrs))))

(defn parse-any
  "Parses an XML schema any."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-any-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-all-content
  "Parses an XML schema all content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :element)
      (parse-element element)
      :default
      (println "WARN: Unhandled tag in all-content:" tag attrs))))

(defn parse-all
  "Parses an XML schema all."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-all-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-min-length-content
  "Parses an XML schema min length content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in min-length-content:" tag attrs))))

(defn parse-min-length
  "Parses an XML schema min length."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-min-length-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-field-content
  "Parses an XML schema field content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in field-content:" tag attrs))))

(defn parse-field
  "Parses an XML schema field."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-field-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-selector-content
  "Parses an XML schema selector content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in selector-content:" tag attrs))))

(defn parse-selector
  "Parses an XML schema selector."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-selector-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-key-content
  "Parses an XML schema key content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :field)
      (parse-field element)
      (= tag :selector)
      (parse-selector element)
      :default
      (println "WARN: Unhandled tag in key-content:" tag attrs))))

(defn parse-key
  "Parses an XML schema key."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-key-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-enumeration-content
  "Parses an XML schema enumeration-content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in enumeration-content:" tag attrs))))

(defn parse-enumeration
  "Parses an XML schema enumeration."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-enumeration-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-any-attribute-content
  "Parses an XML schema any attribute content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in any-attribute-content:" tag attrs))))

(defn parse-any-attribute
  "Parses an XML schema any attribute."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-any-attribute-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-attribute-content
  "Parses an XML schema attribute content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :simpleType)
      (parse-simple-type element)
      :default
      (println "WARN: Unhandled tag in attribute-content:" tag attrs))))

(defn parse-attribute
  "Parses an XML schema attribute."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-attribute-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-attribute-group-content
  "Parses an XML schema attribute group content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :attribute)
      (parse-attribute element)
      :default
      (println "WARN: Unhandled tag in attribute-group-content:" tag attrs))))

(defn parse-attribute-group
  "Parses an XML schema attribute group."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-attribute-group-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-notation-content
  "Parses an XML schema notation content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation) (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in notation-content:" tag attrs))))

(defn parse-notation
  "Parses an XML schema notation."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-notation-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-list-content
  "Parses an XML schema list content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :simpleType)
      (parse-simple-type element)
      :default
      (println "WARN: Unhandled tag in list-content:" tag attrs))))

(defn parse-list
  "Parses an XML schema list."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-list-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-union-content
  "Parses an XML schema union content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation) (parse-annotation element)
      :default
      (println "WARN: Unhandled tag:" tag))))

(defn parse-union
  "Parses an XML schema union."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-list-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-choice-content
  "Parses an XML schema choice content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :any)
      (parse-any element)
      (= tag :element)
      (parse-element element)
      (= tag :group)
      (parse-group element)
      (= tag :sequence)
      (parse-sequence element)
      :default
      (println "WARN: Unhandled tag in choice-content:" tag attrs))))

(defn parse-choice
  "Parses an XML schema choice."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-choice-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-sequence-content
  "Parses an XML schema sequence content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :any)
      (parse-any element)
      (= tag :choice)
      (parse-choice element)
      (= tag :element)
      (parse-element element)
      (= tag :group)
      (parse-group element)
      (= tag :sequence)
      (parse-sequence element)
      :default
      (println "WARN: Unhandled tag in sequence-content:" tag attrs))))

(defn parse-sequence
  "Parses an XML schema sequence."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-sequence-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-group-content
  "Parses an XML schema group content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :choice)
      (parse-choice element)
      (= tag :sequence)
      (parse-sequence element)
      :default
      (println "WARN: Unhandled tag in group-content:" tag attrs))))

(defn parse-group
  "Parses an XML schema group."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-group-content) content)})]
    (assoc parsed :_context (context-map parsed))))


(defn parse-extension-content
  "Parses an XML schema extension content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :attribute)
      (parse-attribute element)
      (= tag :attributeGroup)
      (parse-attribute-group element)
      (= tag :choice)
      (parse-choice element)
      (= tag :group)
      (parse-group element)
      (= tag :sequence)
      (parse-sequence element)
      :default
      (println "WARN: Unhandled tag in extension-content:" tag attrs))))

(defn parse-extension
  "Parses an XML schema extension."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-extension-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-restriction-content
  "Parses an XML schema restriction content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :anyAttribute)
      (parse-any-attribute element)
      (= tag :attribute)
      (parse-attribute element)
      (= tag :enumeration)
      (parse-enumeration element)
      (= tag :group)
      (parse-annotation element)
      (= tag :minLength)
      (parse-min-length element)
      (= tag :sequence)
      (parse-sequence element)
      :default
      (println "WARN: Unhandled tag in restriction-content:" tag attrs))))

(defn parse-restriction
  "Parses an XML schema restriction."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-restriction-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-complex-content-content
  "Parses an XML schema complex content content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :extension)
      (parse-extension element)
      (= tag :restriction)
      (parse-restriction element)
      :default
      (println "WARN: Unhandled tag in complex-content-content:" tag attrs))))

(defn parse-complex-content
  "Parses an XML schema complex content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-complex-content-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-complex-type-content
  "Parses an XML schema complex type content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :all)
      (parse-all element)
      (= tag :annotation)
      (parse-annotation element)
      (= tag :anyAttribute)
      (parse-any-attribute element)
      (= tag :attribute)
      (parse-attribute element)
      (= tag :complexContent)
      (parse-complex-content element)
      (= tag :sequence)
      (parse-sequence element)
      :default
      (println "WARN: Unhandled tag in complex-type-content:" tag attrs))))

(defn parse-complex-type
  "Parses an XML schema complex type."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-complex-type-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-simple-type-content
  "Parses an XML schema simple type content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :list)
      (parse-list element)
      (= tag :restriction)
      (parse-restriction element)
      (= tag :union)
      (parse-union element)
      :default
      (println "WARN: Unhandled tag in simple-type-content:" tag attrs))))

(defn parse-simple-type
  "Parses an XML schema simple type."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-simple-type-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-element-content
  "Parses an XML schema element."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :simpleType)
      (parse-simple-type element)
      (= tag :complexType)
      (parse-complex-type element)
      (= tag :key)
      (parse-key element)
      :default
      (println "WARN: Unhandled tag in element-content:" tag attrs))))

(defn parse-element
  "Parses an XML schema element."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-element-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-import-content
  "Parses an XML schema import content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      :default
      (println "WARN: Unhandled tag in import-content:" tag attrs))))

(defn parse-import
  "Parses an XML schema import."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-import-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-schema-content
  "Parses an XML schema document content."
  [element]
  (let [{tag :tag attrs :attrs content :content} element]
    (cond
      (= tag :annotation)
      (parse-annotation element)
      (= tag :attributeGroup)
      (parse-attribute-group element)
      (= tag :complexType)
      (parse-complex-type element)
      (= tag :element)
      (parse-element element)
      (= tag :group)
      (parse-group element)
      (= tag :import)
      (parse-import element)
      (= tag :notation)
      (parse-notation element)
      (= tag :simpleType)
      (parse-simple-type element)
      :default
      (println "WARN: Unhandled tag in schema-content:" tag attrs))))

(defn parse-schema
  "Parses an XML schema document."
  [element]
  (let [{tag :tag attrs :attrs content :content} element
        parsed (merge attrs
                      {:_tag tag
                       :_content (into [] (map parse-schema-content) content)})]
    (assoc parsed :_context (context-map parsed))))

(defn parse-xsd
  "Loads and parses a XML Schema."
  [xsd]
  (->> xsd
       (slurp)
       (xml/parse-str)
       (parse-schema)))


; generate parser with a depth first post walk from bottom up

(defn generate-element-fn
  ""
  [e]
  (when (element? e)
    (str "(defn parse-" + (:name e) "\n"
         "  \"Parses the XML \""
         "  [e]"
         ") "))
  )

(defn generate-parser
  ""
  [e]
  (let [content (:_content e)]
    (when (not (string? content))
      (loop [c content]
        (if (seq c)
          (recur (rest c))
          (generate-element-fn e))))))

(defn add-named-element
  [name-map element]
  (if (and (named? element) (not (attribute? element)))
    (assoc name-map (:name element) element)
    name-map))

(defn named-element-map
  ""
  ([element]
   (named-element-map {} element))
  ([name-map element]
   (let [new-map (add-named-element name-map element)
         content (:_content element)]
     (when (not (string? content))
       (loop [c content m new-map]
         (if (seq c)
           (recur (rest c) (merge m (named-element-map (first c))))
           m))))))

(defn global-element-map
  ""
  [e]
  (->> (:_content e)
       (filter (comp named? element?))
       (into {} (map (fn [x] [(:name x) x])))))

(defn local-element-map
  ""
  [e]
  (->> (:content e)))

(defn global-attribute-map
  ""
  [e]
  (->> (:_content e)
       (filter (comp named? attribute?))
       (into {} (map (fn [x] [(:name x) x])))))


(comment
  (->>
   (parse-xsd "resources/XMLSchema_1.1.xsd")
   (context-map))
  (pp/pprint (->>
              (parse-xsd "resources/XMLSchema_1.1.xsd")
              (named-element-map))))

(defn print-list
  "Prints a list of elements (without the content of the elements)"
  [coll]
  (doseq [e coll]
    (println (dissoc e :_content))))

(defn print-tree
  "Prints a tree of the elements."
  [indent e]
  (println (str/join (repeat indent "|")) (dissoc e :_content :_context))
  (let [c (:_content e)]
    (when (and (seq c) (not (string? c)))
      (doseq [x c]
        (print-tree (inc indent) x)))))

(defn global-group-map
  ""
  [e]
  (->> (:_content e)
       (filter (comp named? group?))
       (into {} (map (fn [x] [(:name x) x])))))

(defn global-attribute-group-map
  ""
  [e]
  (->> (:_content e)
       (filter (comp named? attribute-group?))
       (into {} (map (fn [x] [(:name x) x])))))

(defn global-complex-type-map
  ""
  [e]
  (->> (:_content e)
       (filter (comp named? complex-type?))
       (into {} (map (fn [x] [(:name x) x])))))

(defn global-simple-type-map
  ""
  [e]
  (->> (:_content e)
       (filter (comp named? simple-type?))
       (into {} (map (fn [x] [(:name x) x])))))

(comment
  (str/join (repeat 5 " "))
  (parse-xsd "resources/XMLSchema_1.1.xsd")
  (parse-xsd "resources/datatypes_1.1.xsd")
  (parse-xsd "resources/XMLSchema.xsd")
  (parse-xsd "resources/maven-4.0.0.xsd")
  (print-list (->>
               (parse-xsd "resources/XMLSchema_1.1.xsd")
;               (parse-xsd "resources/datatypes_1.1.xsd")
;               (parse-xsd "resources/maven-4.0.0.xsd")
               (:_content)
               (filter identified?)
;               (filter optional?)
;               (filter identifiable?)
               ))
  (->>
   (parse-xsd "resources/XMLSchema_1.1.xsd")
   (print-tree 0))
  (->>
   (parse-xsd "resources/XMLSchema_1.1.xsd")
   (:_context)))