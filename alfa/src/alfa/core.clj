(ns alfa.core
  (:require
    [clojure.set :as st :refer [union difference intersection]]
    [clojure.string :as cs :refer [split-lines]]))


(defn prime?
  [x]
  (cond
    (< x 2) false
    (== x 2) true
    (even? x) false
    :else (->> (range 3 (inc (Math/sqrt x)) 2)
               (map #(mod x %))
               (every? pos?))))