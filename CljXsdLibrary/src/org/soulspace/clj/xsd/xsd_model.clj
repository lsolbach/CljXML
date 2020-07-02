(ns org.soulspace.clj.xsd.xsd-model
  (:refer-clojure :exclude [import key list sequence])
  (:import [org.soulspace.clj.xml.marshalling XMLMarshalling XMLUnmarshalling]))

; Complex types
; annotated: annotation ^:attr id
; top-level-attribute: (restriction attribute elements ;[annotation simple-type] ^:attr ref ^:attr form ^:attr use ^:attr name)
;

; Element groups
; redefinable: simple-type complex-type group attribute-group
; schema-top: simple-type complex-type group attribute-group element attribute notation
; type-def-particle: group all choice sequence
; nested-particle: element group choice sequence any
; particle: element group all choice sequence any
; attr-decls: attribute attributeGroup
; complex-type-model: simple-content complex-content [type-def-particle: group all choice sequence] [attr-decls: attribute attributeGroup]]
; complex-type: annotation [simple-content complex-content [type-def-particle: group all choice sequence] [attr-decls: attribute attributeGroup]]]
;               ^:attr id ^:attr name ^:attr mixed ^:attr abstract ^:attr final ^:attr block
; top-level-complex-type:
; local-complex-type:
; facets: (choice min-exclusive min-inclusive max-exclusive max-inclusive total-digits fraction-digits length min-length max-length enumeration white-space pattern)
; simple-restriction-model: [simple-type]
; restriction-type: annotation [(choice [group all choice sequence] )]
;                   ^:attr id ^:attr base


; Attribute groups
; occurs: ^:attr minOccurs ^:attr maxOccurs
; def-ref: ^:attr name ^:attr ref
;

; Types
; form-choice: (restriction NMTOKEN qualified unqualified)
; reduced-derivation-control: (restriction derivation-control extension restriction)
; derivation-set:
; type-derivation-control: (restriction derivation-control extension restriction list union)
; all-nni: (union (non-negative-integers) unbounded)
; use: (restriction NMTOKEN prohibited optional required)

(defrecord Schema
  [elements ; [include import redefine annotation] [simple-type complex-type group attribute-group element attribute notation annotation]
   ^:attr target-namespace ^:attr version ^:attr final-default ^:attr block-default
   ^:attr attribute-form-default ^:attr element-form-default ^:attr id ^:attr lang]
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Attribute
  [elements ; [annotation] [simpleType]
   ^:attr id ^:attr name ^:attr ref ^:attr type ^:attr use ^:attr default ^:attr fixed ^:attr form]
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord All
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Annotation
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Any
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord AnyAttribute
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Appinfo
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord AttributeGroup
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Choice
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord ComplexContent
  [restriction extension ^:attr mixed]
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord ComplexType
  [^:group complex-type-model name mixed abstract final block]
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Document
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Element
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Enumeration
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Extension
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Field
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Group
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Import
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Include
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Key
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Keyref
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Length
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord List
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord MaxInclusive
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord MinInclusive
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord MaxLength
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord MinLength
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Pattern
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Redefine
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Restriction
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Selector
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Sequence
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord SimpleContent
  [annotations restriction extension ^:attr id]
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord SimpleType
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Union
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))


(defrecord Unique
  []
  XMLUnmarshalling
  (from-xml [this xml])

  XMLMarshalling
  (to-xml [this]))
