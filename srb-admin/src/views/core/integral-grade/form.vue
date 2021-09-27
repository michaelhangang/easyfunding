<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="Loan Amount">
        <el-input-number v-model="integralGrade.borrowAmount" :min="0" />
      </el-form-item>
      <el-form-item label="Points Start">
        <el-input-number v-model="integralGrade.integralStart" :min="0" />
      </el-form-item>
      <el-form-item label="Points End">
        <el-input-number v-model="integralGrade.integralEnd" :min="0" />
      </el-form-item>
      <el-form-item>
        <el-button
          :disabled="saveBtnDisabled"
          type="primary"
          @click="saveOrUpdate()"
        >
          Save
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import integralGradeApi from '@/api/core/integral-grade'
export default {
  data() {
    return {
      integralGrade: {},
      saveBtnDisabled: false
    }
  },
  created() {
    if (this.$route.params.id) {
      this.fetchDataById(this.$route.params.id)
    }
  },
  methods: {
    saveOrUpdate() {
      this.saveBtnDisabled = true
      if (!this.integralGrade.id) {
        this.saveData()
      } else {
        this.updateData()
      }
    },

    saveData() {
      // debugger
      integralGradeApi.save(this.integralGrade).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push('/core/integral-grade/list')
      })
    },

    fetchDataById(id) {
      integralGradeApi.getById(id).then(response => {
        this.integralGrade = response.data.record
      })
    },
    updateData() {
      integralGradeApi.updateById(this.integralGrade).then(response => {
        this.$message({
          type: 'success',
          message: response.message
        })
        this.$router.push('/core/integral-grade/list')
      })
    }
  }
}
</script>
