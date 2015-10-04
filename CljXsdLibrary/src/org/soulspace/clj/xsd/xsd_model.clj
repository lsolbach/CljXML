(ns org.soulspace.clj.xsd.xsd-model
  (:refer-clojure :exclude [import key list sequence])
  (:import [org.soulspace.clj.xml.marshalling XMLMarshalling]))

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
  XMLMarshalling 
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Attribute
  [elements ; [annotation] [simpleType]
   ^:attr id ^:attr name ^:attr ref ^:attr type ^:attr use ^:attr default ^:attr fixed ^:attr form]
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord All
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Annotation
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Any
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord AnyAttribute
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Appinfo
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord AttributeGroup
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Choice
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord ComplexContent
  [restriction extension ^:attr mixed]
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord ComplexType
  [^:group complex-type-model name mixed abstract final block]
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Document
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Element
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Enumeration
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Extension
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Field
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Group
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Import
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Include
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Key
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Keyref
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Length
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord List
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord MaxInclusive
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord MinInclusive
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord MaxLength
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord MinLength
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Pattern
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Redefine
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Restriction
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Selector
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Sequence
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord SimpleContent
  [annotations restriction extension ^:attr id]
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord SimpleType
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Union
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))

(defrecord Unique
  []
  XMLMarshalling
  (from-xml [this xml]
    )
  (to-xml [this]
    ))
