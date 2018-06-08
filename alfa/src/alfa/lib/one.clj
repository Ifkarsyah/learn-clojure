(ns alfa.lib.one
  (:require
    [cheshire.core :as cc]))

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