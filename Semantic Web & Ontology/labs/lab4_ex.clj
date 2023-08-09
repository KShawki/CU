(defrule rule1
        (f3)
        (f4)
        (f5)
        =>
        (printout t "rule 1 fires" crlf)
)

(defrule rule2
        (f2)
        =>
        (printout t "rule 2 fires" crlf)
)

(defrule rule3
        (f1)
        (f2)
        =>
       (printout t "rule 3 fires" crlf)
)

(defrule rule4
        (f1)
        (f2)
        (f3)
        =>
        (printout t "rule 4 fires" crlf)
)

(defrule rule5
        (f4)
        (f5)
        =>
        (printout t "rule 5 fires" crlf)
)



