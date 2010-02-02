;Hello world example
(ns ChapterOne.HelloWorld)

;creates a reference and binds to name visitors
(def visitors (ref #{}))

(defn hello
  [name]
  (dosync
    (let [past-visitor (@visitors name)]
      (if past-visitor
        (str "Welcome back, " name)
        (do
          (alter visitors conj name)
          (str "Hello, " name)))))
  )

;ChapterOne.HelloWorld=> (hello "Kev")
;"Hello, Kev"
;ChapterOne.HelloWorld=> (hello "Kev")
;"Welcome back, Kev"