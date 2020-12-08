<template>
  <div class="container">
    <Logo />
    <div v-for="todo in todoList" :key="todo.id">
      {{ todo.hello }}
    </div>
    <button @click="create">Create</button>
    <button @click="update">Update</button>
    <button @click="remove">Remove</button>
  </div>
</template>

<script>
export default {
  async mounted() {
    const response = await this.$axios.get('/api/hello')
    this.todoList = response.data
  },
  data() {
    return {
      search: '',
      todo: {
        id: 1,
        hello: 'hello world!!!',
      },
      todoList: [],
    }
  },
  methods: {
    async create() {
      await this.$axios.post('/api/hello', this.todo).then(() => {
        this.$router.app.refresh()
      })
    },
    async update() {
      await this.$axios
        .put('/api/hello/' + this.todo.id, this.todo)
        .then(() => {
          this.$router.app.refresh()
        })
    },
    async remove() {
      await this.$axios
        .delete('/api/hello/' + this.todo.id, this.todo)
        .then(() => {
          this.$router.app.refresh()
        })
    },
  },
}
</script>

<style>
/* Sample `apply` at-rules with Tailwind CSS
.container {
@apply min-h-screen flex justify-center items-center text-center mx-auto;
}
*/
.container {
  margin: 0 auto;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family: 'Quicksand', 'Source Sans Pro', -apple-system, BlinkMacSystemFont,
    'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
  display: block;
  font-weight: 300;
  font-size: 100px;
  color: #35495e;
  letter-spacing: 1px;
}

.subtitle {
  font-weight: 300;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}
</style>
