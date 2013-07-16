(ns org.soulspace.clj.xsd.xsd-dsl
  (:refer-clojure :exclude [import key list sequence])
  (:use [org.soulspace.clj.xml dsl-builder]))

(def schema-types 
  ["anyURI" "base64Binary" "boolean" "byte" "date" "dateTime" "decimal"
   "double" "duration" "ENTITY" "ENTITIES" "float" "gDay" "gMonth" "gMonthDay"
   "gYear" "gYearMonth" "hexBinary" "ID" "IDREF" "IDREFS" "int" "integer"
   "language" "long" "Name" "NCName" "NMTOKEN" "NMTOKENS" "NOTATION"
   "negativeInteger" "nonNegativeInteger" "nonPositiveInteger"
   "normalizedString" "positiveInteger" "QName" "short" "string" "time"
   "token" "unsignedByte" "unsignedShort" "unsignedInt" "unsignedLong"])

(deftags "xs"
  ["all" "annotation" "any" "anyAttribute" "appinfo" "attribute"
   "attributeGroup" "choice" "complexContent" "complexType" "documentation"
   "element" "enumeration" "extension" "field" "group" "import" "include"
   "key" "keyref" "length" "list" "maxInclusive" "minInclusive" "maxLength"
   "minLength" "pattern" "redefine" "restriction" "selector"
   "sequence" "simpleContent" "simpleType" "union" "unique"])

(defroottags "xs" "http://www.w3.org/2001/XMLSchema" ["schema"])
