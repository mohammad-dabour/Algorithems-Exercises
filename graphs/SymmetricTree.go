package main

import "fmt"

type Node struct {
	//
	Val   int
	Left  *Node
	Right *Node
}

func eachSide(left *Node, right *Node) bool {

	if left == nil && right == nil {
		return true
	}

	if left == nil || right == nil {
		return false
	}

	return ((left.Val == right.Val) && eachSide(left.Left, right.Right) && eachSide(left.Right, right.Left))

}

func isSymmetric(root *Node) bool {

	return eachSide(root.Left, root.Right)

}
func main() {
	root := Node{1, nil, nil}
	root.Left = &Node{2, nil, nil}
	root.Right = &Node{2, nil, nil}
	root.Left.Left = &Node{3, nil, nil}
	root.Left.Right = &Node{4, nil, nil}
	root.Right.Left = &Node{4, nil, nil}
	root.Right.Right = &Node{3, nil, nil}
	fmt.Printf("Given tree is: ")
	if isSymmetric(&root) {
		fmt.Printf("Given tree is Symmetric")
	} else {
		fmt.Printf("Given tree is NOT Symmetric")
	}

}
