<template>
  <div class="app-container">
      <el-table :data="list" border stripe>
      <el-table-column type="index" width="50" />
      <el-table-column prop="borrowAmount" label="Loan Amount" />
      <el-table-column prop="integralStart" label="Points Start" />
      <el-table-column prop="integralEnd" label="Points End" />
    </el-table>
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
