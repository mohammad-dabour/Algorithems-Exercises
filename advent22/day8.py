def row_traverse(grid1, rn, cn):
    left, right = True, True
    scoresLeft = 0
    scoresRight = 0
    # The reason I do not want to use Any([..]) because chances not to iterate over all elements are higher.
    # No need to iterate all elements if one is found.
    # Any() will assume you iterated over all.
    for i in range(cn - 1, -1, -1):
        if grid1[rn][i] >= grid1[rn][cn]:
            left = False
            scoresLeft += 1
            break
        scoresLeft += 1

    for i in range(cn + 1, len(grid1[0])):
        if grid1[rn][i] >= grid1[rn][cn]:
            right = False
            scoresRight += 1
            break
        scoresRight += 1

    # return left or right
    return scoresRight * scoresLeft, left or right


def col_traverse(grid1, rn, cn):
    up, down = True, True
    scoresUp = 0
    scoresDown = 0
    # The reason I do not want to sue Any([..]) because chances not to iterate over all elements are higher.
    # No need to iterate all elements if one is found.
    # Any() will assume you iterated over all.
    for i in range(rn - 1, -1, -1):
        if grid1[i][cn] >= grid1[rn][cn]:
            up = False
            scoresUp += 1
            break

        scoresUp += 1

    for i in range(rn + 1, len(grid1)):
        if grid1[i][cn] >= grid1[rn][cn]:
            down = False
            scoresDown += 1
            break
        scoresDown += 1
    return scoresUp * scoresDown, up or down



def day8():
    inputs = open("test.txt1", "r").readlines()
    grid1 = []
    for line in inputs:  # 6282
        grid1.append(list(line.strip("\n \r")))
    max_score = float("-inf")
    v = len(grid1) * 2 + ((len(grid1[0]) - 2) * 2)  # initial visible elements on edges.
    print("wdith ", len(grid1[0]), "height: ", len(grid1), "v = ", v)
    for i in range(1, len(grid1) - 1):  # we do not need to visit th edges.
        for j in range(1, len(grid1[0]) - 1):  # we do not need to visit th edges.

            current_rows = row_traverse(grid1, i, j)
            current_col = col_traverse(grid1, i, j)

            if current_rows[1] or current_col[1]:
                v += 1
            max_score = max(max_score, current_rows[0] * current_col[0])

    print(v)
    print(max_score)


day8()
