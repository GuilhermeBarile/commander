(ns commander.core
  (:require [seesaw.core :as s])
  (:gen-class))

(defn- center! [frame]
  (.setLocationRelativeTo frame nil)
  frame)

(defn is-dir? [f]
  (.isDirectory f))

(defn file-list [path]
  (let [file (clojure.java.io/file path)]
    (if (.isDirectory file)
      (filter #(if (.isDirectory %) (.getName %) false) (.listFiles file))
      [])))

(defn file-box [model]
  (s/listbox :model model))

(defn -main [& args]
  (s/native!)
  (s/invoke-later
    (-> (s/frame :title "Commander"
                 :content (s/left-right-split 
                            (s/scrollable (file-box (file-list "C:\\"))) 
                            (s/scrollable (file-box (file-list "C:\\Users")))
                            :divider-location 1/2)
                 :on-close :exit
                 :size [800 :by 600])
        center!
        s/show!)))
