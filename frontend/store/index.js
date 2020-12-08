export const state = () => ({
  todos: [
    {
      id: 1,
      task: 'タスク1',
    },
    {
      id: 10,
      task: 'タスク10',
    },
  ],
})
export const getters = {
  getTodos(state) {
    return state.todos
  },
}
export const mutations = {
  addTodo(state, paylaod) {
    state.todos.push(paylaod.todo)
  },
  updateTodo(state, paylaod) {
    state.todos.forEach((todo, index) => {
      if (todo.id === paylaod.todo.id) {
        state.todos.splice(index, 1, paylaod.todo)
      }
    })
  },
  removeTodo(state, paylaod) {
    state.todos.forEach((todo, index) => {
      if (todo.id === paylaod.todo.id) {
        state.todos.splice(index, 1)
      }
    })
  },
}
