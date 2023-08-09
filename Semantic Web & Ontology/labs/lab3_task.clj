;Add these facts to clips working memory
;Ahmed is the father of Mohammed
;Mona is the mother of Ali
;Ali is the father of Sara
;Hassan is the father of Ahmed

;Write rules that infer and add  parents, grandfathers, grandmothers facts and prints them out

(deffacts family
   (father Ahmed Mohammed)
   (mother Mona Ali)
   (father Ali Sara)
   (father Hassan Ahmed)
)

(defrule parent
   (or (father ?parent ?name) (mother ?parent ?name))
   =>
   (assert(parent ?parent ?name))
   (printout t ?parent " is one of the parents of " ?name crlf )
) 

(defrule grandfather
   (and (father ?grandpa ?parent) (or (father ?parent ?name) (mother ?parent ?name)) )
   =>
   (assert(grandfather ?grandpa ?name))
   (printout t ?grandpa " is grandfather of " ?name crlf )
) 

(defrule grandmother
   (and (mother ?grandma ?parent) (or (father ?parent ?name) (mother ?parent ?name)) )
   =>
   (assert(grandmother ?grandma ?name))
   (printout t ?grandma " is grandmother of " ?name crlf )
) 