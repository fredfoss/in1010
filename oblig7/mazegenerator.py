import random


def generate_maze(rows, cols):
  maze = [['#'] * cols for _ in range(rows)]
  stack = [(0, 0)]
  while stack:
    row, col = stack.pop()
    if maze[row][col] == '#':
      maze[row][col] = '.'
      neighbors = [(row - 1, col), (row + 1, col), (row, col - 1),
                   (row, col + 1)]
      random.shuffle(neighbors)
      for n_row, n_col in neighbors:
        if 0 <= n_row < rows and 0 <= n_col < cols:
          stack.append((n_row, n_col))
  return maze


def print_maze(maze):
  rows = len(maze)
  cols = len(maze[0])
  print(rows, cols)
  for row in maze:
    print(''.join(row))


if __name__ == '__main__':
  maze = generate_maze(10, 10)
  print_maze(maze)
