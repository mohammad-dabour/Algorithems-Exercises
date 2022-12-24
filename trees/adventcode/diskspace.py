#This is adventofcode2022 day7 solution. I usually do not post my solution about adventcode  unless if I find the problem interesting.
class File:
    def __init__(self, parent, name, size) -> None:
        self.name = name
        self.file_size = size

    @property
    def size(self):
        return self.file_size


class Node:
    def __init__(self, parent, name) -> None:

        self.node_name = name
        self.node_size = 0.0
        self.node_parent = parent
        self.file_list = []

    def setsize(self, size):
        self.node_size += size

    @property
    def size(self):
        return self.node_size

    @size.setter
    def size(self, size):
        self.node_size += size

    @property
    def parent(self):
        return self.node_parent

    @property
    def name(self):
        return self.node_name

    def files(self, file):
        self.file_list.append(file)
        self.setsize(file.file_size)


def main():
    inputs = open("inputs.txt", "r").readlines()
    rootNode = Node(None, "/")

    all_nodes = []
    stack = [] # to track the lef over files.

    all_nodes.append(rootNode)

    for line in inputs:

        if "cd /" in line:
            currentNode = rootNode
            stack.append(currentNode)
        elif "dir " in line:
            continue
        elif "cd .." in line:
            currentNode.parent.setsize(currentNode.size)
            currentNode = currentNode.parent
            stack.pop()
            
        elif "cd " in line:
            currentNode = Node(currentNode, line.strip(" \n \r ").split(" ")[2])
            all_nodes.append(currentNode)
            stack.append(currentNode)
            
        elif "$ ls" in line:
            continue
            
        elif "dir " not in line and "$" not in line:
            p1, p2 = line.strip(" \n \r ").split(" ")
            file = File(currentNode, p2, int(p1))
            currentNode.files(file)

    # Left over, the nested directories which we did not leave.
    if len(stack) > 0:
        l = len(stack)
        while l > 1:
            item = stack.pop()

            item.parent.setsize(item.size)
            l -= 1

    ####Part 1
    sum = 0
    for node in all_nodes:
        if node.size <= 100000:
            sum += node.size
    print(int(sum))

    ####Part 2

    remainingSpace = 70000000 - rootNode.size

    to_delete = []

    Ineed = 30000000 - remainingSpace
    for dir in all_nodes:
        if dir.size >= Ineed:
            to_delete.append(dir.size)
    to_delete.sort()
    print(to_delete[0])


main()
