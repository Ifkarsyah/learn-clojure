 (ns alfa.core.pararel
   (:require
     [alfa.core :as core :refer [prime?]]))


;; A. KONSEP PARAREL

;; pvalues--> kerjain secara pararel
 (def contohpvalues
   "Memanfaatkan 3 core berbeda, bakal penting banget kalo di server."
   (pvalues (reduce + (filter prime? (range 10000)))
            (reduce + (filter prime? (range 10000 20000)))
            (reduce + (filter prime? (range 20000 40000)))))
;; pmap --> kerjain secara pararel

;; B. KONSEP REDUCE
;;    ada yang transduce => reduce, ada yang sequence=>

 (defn sum-prime-1 [lim]
   (->> (range 3 lim 2)                                     ;; bangun list sekali
        (map #(+ % (rand-int 100)))                         ;; bangun list lagi
        (filter prime?)                                     ;; bangun list lagi
        (reduce +)
        time))

 (def xform-fun
   (comp (map #(+ % (rand-int 100)))                        ;; tiap 1 elemen
         (filter prime?)))                                  ;; proses 2 operasi ini

 (defn sum-prime-2 [lim]
   (sequence xform-fun (range 3 lim 2)))                    ;; bikin lazy-sequence

 (defn sum-prime-2b [lim]
   (transduce xform-fun + (range 3 lim 2)))