(ns alfa.lib.one
  (:require
    [cheshire.core :as cc]
    [clojure.math.combinatorics :as combo]))

;; USING CHESHIRE.CORE
(defn toJSON [name age hobby]
  (cc/generate-string {:name name :age age :hobby hobby}))

(def useToJSON
  (toJSON "Ferdi" 19 "Soccer"))

(defn toClojure [jsonstring]
  (cc/parse-string jsonstring true))

;; USING MATH COMBINATORICS
(defn permutation-contoh [n]
  (combo/permutations (vec (range 1 (inc n)))))

(defn pilih-n-dari [lst n]
  (combo/combinations lst n))


;; CLOJURE VIDEO 7

(defprotocol SaySomething                                   ;; ngebikin fungsi umum
  (say-hi [this])                                           ;; kalo conj misalnya, kan
  (set-score [this change]))                                ;; beda2 kalo digunain ke list, vector, set,dll


(defrecord Person [nama status score]
  SaySomething
  (say-hi [this]
    (str "Hello " (:nama this) " njing!!"))
  (set-score [this change]
    (+ (:score this) change)))

(defrecord Animal [nama status ctype]
  SaySomething
  (say-hi [this]
    (str "Hello " (:nama this) " !!"))
  (set-score [this change]
    (+ (:score this) (* change 2))))