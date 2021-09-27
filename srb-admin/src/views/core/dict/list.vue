<template>
  <div class="app-container">
    <div style="margin-bottom: 10px;">
      <el-button
        @click="dialogVisible = true"
        type="primary"
        size="mini"
        icon="el-icon-download"
      >
        Import Excel
      </el-button>
      <el-button
        @click="exportData"
        type="primary"
        size="mini"
        icon="el-icon-upload2" >Export Excel</el-button>
    </div>

    <el-dialog title="Data Dict Import" :visible.sync="dialogVisible" width="30%">
      <el-form>
        <el-form-item label="Select Excel File">
          <el-upload
            :auto-upload="true"
            :multiple="false"
            :limit="1"
            :on-exceed="fileUploadExceed"
            :on-success="fileUploadSuccess"
            :on-error="fileUploadError"
            :action="BASE_API + '/admin/core/dict/import'"
            name="file"
            accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
          >
            <el-button size="small" type="primary">Upload</el-button>
          </el-upload>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">
          Cancel
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  // 定义数据
  data() {
    return {
      dialogVisible: false,
      BASE_API: process.env.VUE_APP_BASE_API
    }
  },

  methods: {
    fileUploadExceed() {
      this.$message.warning('Only Select One File')
    },

    fileUploadSuccess(response) {
      if (response.code === 0) {
        this.$message.success('Success')
        this.dialogVisible = false
      } else {
        this.$message.error(response.message)
      }
    },

    fileUploadError() {
      this.$message.error('Failed')
    },

    exportData() {
      window.location.href = this.BASE_API + '/admin/core/dict/export'
    }
  }
}
</script>
