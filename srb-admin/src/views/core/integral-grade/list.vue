<template>
  <div class="app-container">
    Points Level List
  </div>
</template>
<script>
import integralGradeApi from '@/api/core/integral-grade'
export default {
  data() {
    return {
      list: []
    }
  },

  created() {
    this.fetchData()
  },

  methods: {
    fetchData() {
      integralGradeApi.list().then(response => {
        this.list = response.data.list
      })
    }
  }
}
</script>
