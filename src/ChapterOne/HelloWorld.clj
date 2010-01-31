;Hello world example

(ns ChapterOne.HelloWorld
  (:use clojure.test))

(defn hello
  [name]
  (dosync
    (let [past-visitor (@visitors username)]
      (if past-visitor
        (str "Welcome back, " name)
        (do
          (alter visitors conj name)
          (str "Hello, " name)))))
  )


