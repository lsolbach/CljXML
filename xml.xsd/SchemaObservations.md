XML Schema Observations
=======================

Reference
---------
XML Schema 1.1 Recomendation, W3C, 2012
XML Schema; Van der Vlist, Eric; O'Reilly; 2002


Named definitions
-----------------
Named definitions defined directly under the root element "schema" are global definitions.
Global definitions can be referenced from anywhere in the document.
Global named element definitions can be the root element of an instance document.

Named definitions defines in children of the root element "schema" are local definitions.
Local definitions can only be referenced in the context in which they are defined.
Local definitions shadow global definitions in the context in which they are defined.

Global and local definitions of the same element can have different content models.


Processing model
----------------
Serialization space - contains the actual bytes stored in the document
Transformation space - contains the items after unicode conversion and first whitespace processing
Lexical space - contains the lexical representation of an item according to the whitespace processing rules for the datatype of the item.
Value space - contains the value of an item according to the datatype of the item

In the context of dedicated parser generation the lexical space and the value space are relevant.

Content Models and Content Types
--------------------------------
There are different content models for an element which exist independently from the existence of attributes in an element.
* Empty
* Simple
* Complex
* Mixed

Elements with a simple content model and no attributes are defined to be of simple type.
Elements with attributes and other content models are defined to be of complex type.


Simple Types
------------
Simple types as datatypes are about definitions and constraints on the leaf nodes and attributes.
Simple types can be named or anonymous.
Simple types support derivation by restriction, by list and by union.

Complex Types
-------------
Complex types are about definitions and constraints of the structure of the instance documents.
Complex types can be named or anonymous.

