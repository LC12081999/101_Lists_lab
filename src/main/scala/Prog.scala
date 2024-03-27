object Prog extends App {
  var n = new LinkedList()
  n.addToEnd("Alice")
  n.addToEnd("Bob")
  n.addToEnd("Cathy")
  n.removeElement("Alice")
  println(n.toString)
}
