node {
    currentBuild.result = "SUCCESS"
    try {
        stage 'Clone Project'
            git 'https://github.com/Dkra/cra-jenkins'
            sh """
                ls -al
            """

        stage 'Install NodeJS'
            sh """
                wget https://nodejs.org/dist/v8.11.3/node-v8.11.3-linux-x64.tar.xz
                tar -vxf node-v8.11.3-linux-x64.tar.xz
                export PATH="`pwd`/node-v8.11.3-linux-x64/bin:$PATH"
            """

        stage 'Npm install'
            sh """
                export PATH="`pwd`/node-v8.11.3-linux-x64/bin:$PATH"
                npm install
            """

        /*
        stage 'Test'
            sh """
                export PATH=`pwd`/node-v8.11.3-linux-x64/bin:$PATH
                npm run test
            """
        */

        stage 'Build'
            sh """
                export PATH="`pwd`/node-v8.11.3-linux-x64/bin:$PATH"
                npm run build
            """

        stage 'Notify Slack'
          def attachments = [
            [
                text: 'I find your lack of faith disturbing!',
                fallback: 'Hey, Vader seems to be mad at you.',
                color: '#5afa60'
            ]
          ]

          slackSend(attachments: attachments)
    } catch (err) {

        throw err

    } finally {
       sh """
            rm -rf ./node_modules node-v8.*
        """
    }
}
