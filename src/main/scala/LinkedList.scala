class LinkedList(n: Node = null) {
  private var _head: Node = n

  def head = _head

  def addToStart(s: String): Unit = {
    _head = new Node(s, _head)
  }

  def getSize(): Int = {
    def getSizeRec(current: Node, counter: Int = 0): Int = {
      if (current != null) {
        return getSizeRec(current.next, counter + 1)
      } else return counter
    }

    getSizeRec(_head)
  }

  override def toString: String = {
    if (_head == null) return "List content (size 0) : null"
    var res: String = s"List content (size ${getSize()}) : ${_head.item}"
    var current: Node = _head.next
    while (current != null) {
      res += s"  ->  ${current.item}"
      current = current.next
    }
    return res + s"  ->  null"
  }

  def removeFirstElement: Unit = {
    if (_head == null) return
    _head = _head.next
  }

  def getLastElement: Node = {
    var current = _head
    if (_head == null) return null
    else {
      while (current.next != null) current = current.next
    }
    return current
  }

  def addToEnd(s: String): Unit = {
    if (_head == null) {
      _head = new Node(s, null)
      return
    }
    getLastElement.next = new Node(s)
  }

  def isPresent(s: String): Boolean = {
    if (s == null) return false
    var current = _head
    while (current != null) {
      if (current.item.toLowerCase == s.toLowerCase) return true
      else current = current.next
    }
    return false
  }

  def findElement(s: String): Node = {
    var current = _head
    while (current != null) {
      if (current.item.toLowerCase == s.toLowerCase) return current
      else current = current.next
    }
    return null
  }

  def swapElements(e1: String, e2: String): Unit = {
    if (!(isPresent(e1) && isPresent(e2))) return
    var current = _head
    var comeFirst = ""
    var comeSecond = ""
    while (comeFirst == "") {
      if (current.item == e1) {
        comeFirst = e1
        comeSecond = e2
      } else if (current.item == e2) {
        comeFirst = e2
        comeSecond = e1
      }
      current = current.next
    }
    current = _head
    while (true) {
      if (current.item == comeFirst) {
        current.item = comeSecond
        current = current.next
      } else if (current.item == comeSecond) {
        current.item = comeFirst
        return
      } else current = current.next
    }
  }

  def removeLastElement: Unit = {
    if (_head == null) return
    if (_head.next == null) {
      _head = null
      return
    }
    if (_head.next.next == null) {
      _head.next = null
      return
    }
    var current = _head
    while (current.next != null) {
      current = current.next
      if (current.next.next == null) {
        current.next = null
        return
      }
    }
  }

  def removeElement(s: String): Unit = {
    var current = _head
    if (!isPresent(s)) return
    if (s.toLowerCase == _head.item.toLowerCase) {
      _head = _head.next
      return
    }
    if (s.toLowerCase == getLastElement.item.toLowerCase) {
      removeLastElement
      return
    }
    while (current.next != null) {
      if (current.next.item.toLowerCase == s.toLowerCase) {
        current.next = current.next.next
      }
      current = current.next
    }
  }

  def insertAfter(before: String, after: String): Unit = {
    if (_head == null) throw new IllegalArgumentException
    if (!isPresent(before)) return
    var current = _head
    while (true) {
      if (current.item.toLowerCase == before.toLowerCase) {
        current.next = new Node(after, current.next)
        return
      }
      if (current.next == null) return
      current = current.next
    }
  }
}
