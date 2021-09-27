<template>
  <div class="app-container">
      <el-table :data="list" border stripe>
      <el-table-column type="index" width="50" />
      <el-table-column prop="borrowAmount" label="Loan Amount" />
      <el-table-column prop="integralStart" label="Points Start" />
      <el-table-column prop="integralEnd" label="Points End" />
        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <router-link :to="'/core/integral-grade/edit/' + scope.row.id" style="margin-right:5px;" >
              <el-button type="primary" size="mini" icon="el-icon-edit">
                Edit
              </el-button>
            </router-link>
            <el-button
              type="danger"
              size="mini"
              icon="el-icon-delete"
              @click="removeById(scope.row.id)"
            >
              Delete
            </el-button>
          </template>
        </el-table-column>
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
    },

    removeById(id) {
      this.$confirm('Delete or Cancel', 'Warning', {
        confirmButtonText: 'Yes',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        return integralGradeApi.removeById(id)
      })
        .then(response => {
          this.$message.success(response.message)
          this.fetchData()
        })
        .catch((error) => {
          if (error === 'cancel') {
            this.$message.info({
              type: 'info',
              message: 'Cancel delete'
            })
          }
        })
    }


  }
}
</script>
