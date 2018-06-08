(ns alfa.core.stm
  (require
    [alfa.core.pararel :refer [sum-prime-1]]))

(def number-1 100)                                          ;; cuma bisa diubah kalo di-def lagi

(def number-2 (atom 200))                                   ;; mirip pointer di c++

(def jalanin-1
  (pmap #(reset! number-2 (+ % @number-2)) (range 10)))     ;; hasilnya acak/ngaco

;; ada fungi swap! dan reset!

(def number-3 (ref 0))

;; ada dosync, ref-set, alter, commute



;; NUNDA OPERASI--> future

(def result-1 (sum-prime-1 10000000))                       ;; harus nunggu ini selesai
(def result-2 (future (sum-prime-1 100000000)))             ;; kerjain di thread lain, bisa kerjain yang lain dulu



;; CLOJURE VIDEO 5 BELOM SAMSEK